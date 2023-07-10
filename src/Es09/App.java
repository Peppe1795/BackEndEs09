package Es09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App {

	static Connection conn = null;

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/school_students?useSSL=false";
		String username = "postgres";
		String password = "Peppeswor6";

		try {
			System.out.println("Connecting to Postgres");

			conn = DriverManager.getConnection(url, username, password);

			System.out.println("Connected succesfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

		insertStudente("luca", "puccino", "f", 7, 9, 6, "15/02/1996");
		update("Giovanni", "lucertola", "f", 4, 5, 2, "15/02/1992");
	}

	public static void insertStudente(String name, String lastName, String gender, int avg, int minVote, int maxVote,
			String brithDate) {
		String sqlInsert = "INSERT INTO school_students (name, last_name, gender, avg, min_vote, max_vote, birthdate) VALUES (?, ?, ?, ?, ?, ?, ?);";
		try {
			PreparedStatement s = conn.prepareStatement(sqlInsert);
			s.setString(1, name);
			s.setString(2, lastName);
			s.setString(3, gender);
			s.setInt(4, avg);
			s.setInt(5, minVote);
			s.setInt(6, maxVote);
			s.setString(7, brithDate);
			s.execute();

			System.out.println("Studente salvato!!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void update(String name, String lastName, String gender, int avg, int minVote, int maxVote,
			String brithDate) {
		String sqlUpdate = "UPDATE school_students name=?, last_name=?, gender=?, avg=?, min_vote=?, max_vote=?, birthdate=? WHERE id=?";
		try {
			PreparedStatement s = conn.prepareStatement(sqlUpdate);
			s.setString(1, name);
			s.setString(1, lastName);
			s.setString(1, gender);
			s.setInt(1, avg);
			s.setInt(1, minVote);
			s.setInt(1, maxVote);
			s.setString(1, brithDate);
			s.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
