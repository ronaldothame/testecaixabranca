package org.example;

//Os imports estabelecem uma conexão com um banco de dados utilizando JDBC
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    public Connection conectaBD() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://127.0.0.1/teste?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
            return conn;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean testaUsuario(String login, String senha) {
    // Variável para armazenar o resultado da verificação de usuário
    boolean result = false;
    // Declaração da consulta SQL
    String sql = "";

    // Estabelecimento da conexão com o banco de dados
    Connection conn = conectaBD();

    // Montagem da consulta SQL para verificar se o usuário e senha correspondem
    sql += "select nome from usuarios ";
    sql += "where login = '" + login + "'";
    sql += " and senha = '" + senha + "'";

    try {
        // Criação de uma instrução para executar a consulta SQL
        Statement st = conn.createStatement();
        // Execução da consulta SQL e armazenamento do resultado em um ResultSet
        ResultSet rs = st.executeQuery(sql);

        // Verificação se a consulta retornou algum resultado
        if (rs.next()) {
            // Se o resultado existe, o usuário e senha estão corretos
            result = true;
            // Obtém o nome do usuário a partir do ResultSet
            nome = rs.getString("nome");
        }

    } catch (Exception e) { }

    // Retorna o resultado da verificação de usuário
    return result;
}
//fim da class
