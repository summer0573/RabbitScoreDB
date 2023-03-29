package rabbitDB;

import java.sql.*;

//ranking 출력
//1~5위까지
public class ShowStage1RankingDB {
    public ShowStage1RankingDB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/rabbitScoreDB";
        String userName = "root";
        String password = "@summer0573";

        Connection con = DriverManager.getConnection(url, userName, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT name, first_score FROM rabbit_table ORDER BY first_score DESC LIMIT 5;"); //이름, 스테이지2 점수를 점수 내림차순으로 정렬 후 5개만 출력

        int rank = 1; //등수
        while (rs.next()) {
            System.out.println( rank + "등\t" +
                    rs.getString("name") + "\t" +
                    rs.getInt("first_score") + "\t"
//                    rs.getInt("first_clear") + "\t" +
//                    rs.getInt("second_score") + "\t" +
//                    rs.getInt("second_clear")
                    );
            rank++;
        }

        con.close();
        stmt.close();
        rs.close();
    }
    public static void main(String[] args) throws SQLException {
        new ShowStage1RankingDB();
    }
}
