import java.sql.*;
import ucanaccess.*;

public class Executa {
    public static void main(String args[])  {

        String caminhoDoArquivoDoBancoDeDados = "jdbc:ucanaccess://c://Users//f136450//IdeaProjects//access_microsoft//Database1.accdb";

        try (Connection conexao = DriverManager.getConnection(caminhoDoArquivoDoBancoDeDados)) {


            String consulta = "SELECT * FROM Contacts";

            PreparedStatement preparedStatement = conexao.prepareStatement(consulta);

            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(consulta);

            while (resultado.next()) {
                int id = resultado.getInt("Contact_ID");
                String fullname = resultado.getString("Full_Name");
                String email = resultado.getString("Email");
                String phone = resultado.getString("Phone");

                System.out.println(id + ", " + fullname + ", " + email + ", " + phone);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
