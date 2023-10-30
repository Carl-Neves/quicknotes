package dao;

import model.Anotacao;
import model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


public class AnotacaoDAO {
    private Connection connection;

    public AnotacaoDAO() throws SQLException {
        this.connection = DBConnection.getConnection();
    }
//———————————————————————————————————————ADICIONA NOVAS ANOTAÇÕES——————————————————————————————
    public void inserir(String titulo, String conteudo, String data, int categoria) throws SQLException {
        String sql = "INSERT INTO anotacao VALUES(null,?,?,?,?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, titulo);
        statement.setString(2, conteudo);
        statement.setString(3, data);
        statement.setInt(4, categoria);

        statement.executeUpdate();
    }
//———————————————————————————————————————DELETA AS ANOTAÇÕES——————————————————————————————
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM anotacao WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        statement.executeUpdate();

    }
    //——————————————————————————————————————ATUALIZA AS ANOTAÇÕES——————————————————————————————
    public void atualizar(String coluna, String novaAnotacao, int id ) throws SQLException {
        String sql = "UPDATE anotacao SET "+ coluna +" = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        //        statement.setString(1, coluna);
        statement.setString(2, novaAnotacao);
        statement.setInt(3, id);

        statement.executeUpdate();
    }
    // ———————————————————————————————————————EXIBE NOVAS ANOTAÇÕES——————————————————————————————
    public List<Anotacao> listar() {
        List<Anotacao> anotacoes = new ArrayList<>();
        String sql = "SELECT * FROM anotacao";

        try (PreparedStatement stmt = connection.prepareStatement(sql);

             ResultSet rs = stmt.executeQuery()) {
//——————————————————————————————————————————————————————————————————————————————————

            while (rs.next()) {
                Anotacao anotacao = new Anotacao();
                anotacao.setId(rs.getInt("id"));
                anotacao.setTitulo(rs.getString("titulo"));
                anotacao.setConteudo(rs.getString("conteudo"));
                anotacao.setData(rs.getString("data"));
                anotacao.setCategoria(rs.getInt("categoria_id"));

//                String dataAsString = rs.getString("data");

//                Categoria categoria = new Categoria();
//                categoria.setId(rs.getInt("categoria_id"));
//                categoria.setNome(rs.getString("categoria_nome"));

//                anotacao.setCategoria(categoria);
                anotacoes.add(anotacao);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return anotacoes;
    }

    // ... Outros métodos CRUD (criar, atualizar, deletar, etc.)
}
