package app;

import static spark.Spark.*;

import com.google.gson.Gson;

import dao.ProdutoDAO;
import model.Produto;

import java.nio.file.Files;
import java.nio.file.Paths;


public class Aplicacao {
    public static void main(String[] args) {
        port(4567);
        staticFiles.location("/"); // para acessar os HTMLs
        Gson gson = new Gson();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        // Teste
        get("/hello", (req, res) -> "Servidor rodando com Spark!");

        // CREATE
        post("/produtos", (req, res) -> {
            Produto p = gson.fromJson(req.body(), Produto.class);
            produtoDAO.inserir(p);
            res.status(201);
            return "Produto inserido com sucesso!";
        });

        // READ (todos)
        get("/produtos", (req, res) -> {
            res.type("application/json");
            return gson.toJson(produtoDAO.listar());
        });

        // READ (por id)
        get("/produtos/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Produto p = produtoDAO.buscar(id);
            if (p != null) {
                res.type("application/json");
                return gson.toJson(p);
            } else {
                res.status(404);
                return "Produto não encontrado";
            }
        });

        // UPDATE
        put("/produtos/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Produto p = gson.fromJson(req.body(), Produto.class);
            p.setId(id);
            boolean atualizado = produtoDAO.atualizar(p);
            return atualizado ? "Produto atualizado!" : "Erro ao atualizar.";
        });

        // DELETE
        delete("/produtos/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            boolean deletado = produtoDAO.deletar(id);
            return deletado ? "Produto deletado!" : "Erro ao deletar.";
        });
        
        // ======================================== //
        // == Métodos para rotas / arquivos HTML ==
        // ======================================== //
        get("/formulario.html", (req, res) -> {
            res.type("text/html");
            return new String(Files.readAllBytes(Paths.get("src/main/resources/formulario.html")));
        });

        get("/dashboard.html", (req, res) -> {
            res.type("text/html");
            return new String(Files.readAllBytes(Paths.get("src/main/resources/dashboard.html")));
        });
        // ======================================== //
        // == Métodos para rotas / arquivos HTML ==
        // ======================================== //
        
        
        // Total de produtos
        get("/produtos/total", (req, res) -> {
            res.type("application/json");
            int total = produtoDAO.listar().size();
            return "{\"total\": " + total + "}";
        });

        // Valor total em estoque
        get("/produtos/valor-estoque", (req, res) -> {
            res.type("application/json");
            double valorEstoque = produtoDAO.listar().stream()
                .mapToDouble(p -> p.getPreco() * p.getQuantidade())
                .sum();
            return "{\"valorEstoque\": " + valorEstoque + "}";
        });

    }
}
