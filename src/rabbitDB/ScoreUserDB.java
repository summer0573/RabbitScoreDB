package rabbitDB;

import java.sql.*;

//유저 점수 저장
public class ScoreUserDB {
    public ScoreUserDB(){
        String url = "jdbc:mysql://localhost:3306/rabbitScoreDB";
        String userName = "root";
        String password = "@summer0573";

        //new ScoreDBHelper();

//        String name;
//        int first_score;
//        boolean first_clear;
//        int second_score;
//        boolean second_clear;

        //임시 데이터
        //추후 입력값 받아 저장
        String name = "손제티";
        int first_score = 22222;
        int first_clear = 1;
        int second_score = 33333;
        int second_clear = 1;
        //true = 1 / false = 0
        //mysql의 boolean은 0, 1로 입력
        //^자바에서만인가... 왜지

        try{
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(" INSERT INTO rabbit_table(name, first_score, first_clear, second_score, second_clear)" +
                    "VALUES ('" + name + "', '" + first_score + "', '" + first_clear + "', '" + second_score + "', '" + second_clear + "')");//테이블에 스코어를 추가 시키는 큐리문
            System.out.println("데이터 저장 성공");
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("데이터 저장 실패");
        }

    }

    public static void main(String[] args) throws SQLException {
        new ScoreUserDB();
    }

}
