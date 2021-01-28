package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface ConnectionManager {

	public Connection open(String jdbcUrl);

	public void close(Connection conn);
	
	public void close(PreparedStatement preparedStatement);
	
	public void close(ResultSet resultSet);

}
