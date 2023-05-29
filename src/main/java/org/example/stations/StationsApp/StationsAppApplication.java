package org.example.stations.StationsApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class StationsAppApplication implements CommandLineRunner {

	private final JdbcTemplate jdbcTemplate;

	public StationsAppApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public static void main(String[] args) {

		SpringApplication.run(StationsAppApplication.class, args);
	}

	public void run(String... args) {
		String[] filePaths = new String[]{
				"C:\\Users\\levan\\Desktop\\ExcelFilesForProject\\2021-05.csv"
		};
		String tableNameMay = "may";
		String columnsMay = "(departure, \"return\", departure_station_id, departure_station_name, return_station_id, return_station_name, covered_distance, duration)";
		String delimiter = ";";
		String quote = "\"";
		String escape = "''";
		String whereClause = " WHERE duration >= 10 AND covered_distance >= 10";
		for (String filePath : filePaths) {
			String sql = String.format("COPY %s %s FROM '%s' DELIMITER '%s' CSV HEADER QUOTE '%s' ESCAPE '%s'%s;", tableNameMay, columnsMay, filePath, delimiter, quote, escape, whereClause);
			int result = jdbcTemplate.update(sql);
			if (result == 0) {
				System.out.println("Data from file " + filePath + " successfully loaded into database");
			}
		}
		String[] filePathsSt = new String[]{
				"C:\\Users\\levan\\Desktop\\ExcelFilesForProject\\stations.csv"
		};

		for (String filePathSt : filePathsSt) {
			String sqlCheck = "SELECT COUNT(*) FROM stations WHERE fid = 1"; // Replace "1" with the appropriate fid value to check
			int count = jdbcTemplate.queryForObject(sqlCheck, Integer.class);
			if (count == 0) {
				String sql = String.format("COPY stations (fid,id, nimi, namn, name, osoite, adress, kaupunki, stad, operaattor, kapasiteet, x, y) FROM '%s' DELIMITER ',' CSV HEADER", filePathSt);
				int result = jdbcTemplate.update(sql);
				if (result == 0) {
					System.out.println("Data from file " + filePathSt + " could not be loaded into the database");
					System.out.println(sql); // Return the SQL statement
				} else {
					System.out.println("Data from file " + filePathSt + " successfully loaded into the database");
					String sqlSt = "SELECT * FROM stations";
					int resultSt = jdbcTemplate.update(sqlSt);
					if (resultSt != 0) {
						System.out.println(sqlSt); // Return the SQL statement
					}
				}
			}

		}
	}
}