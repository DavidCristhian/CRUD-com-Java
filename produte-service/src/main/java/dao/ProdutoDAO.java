package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDAO {
    private Connection conn;

    public ProdutoDAO() {
        try {
            conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/produtoServices",
                "postgres",
                "123"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inserir(Produto p) {
        String sql = "INSERT INTO produto (nome, preco, quantidade, descricao) VALUES (?, ?, ?, ?)";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, p.getNome());
            st.setDouble(2, p.getPreco());
            st.setInt(3, p.getQuantidade());
            st.setString(4, p.getDescricao());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto ORDER BY id";
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Produto(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getDouble("preco"),
                    rs.getInt("quantidade"),
                    rs.getString("descricao")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Produto buscar(int id) {
        String sql = "SELECT * FROM produto WHERE id = ?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Produto(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getDouble("preco"),
                    rs.getInt("quantidade"),
                    rs.getString("descricao")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean atualizar(Produto p) {
        String sql = "UPDATE produto SET nome = ?, preco = ?, quantidade = ?, descricao = ? WHERE id = ?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, p.getNome());
            st.setDouble(2, p.getPreco());
            st.setInt(3, p.getQuantidade());
            st.setString(4, p.getDescricao());
            st.setInt(5, p.getId());
            return st.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deletar(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, id);
            return st.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
