package unama.br.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import unama.br.Modelo.Aluno;

public class AlunoDAO {
	
	private DataSource datasource;
	private List<Aluno> listaAlunos;
	
	public AlunoDAO(DataSource datasource) {
		this.datasource = datasource;
		
	}
	
	public List<Aluno> consultaAlunos(){
		Connection con= null;
		Statement stm= null;
		ResultSet rs = null;
		listaAlunos = new ArrayList<Aluno>();
		try {
		
		con=datasource.getConnection();
		String sql = "select * from aluno order by primeiro_nome";
		stm = con.createStatement();
		rs = stm.executeQuery(sql);
		while(rs.next()) {
			int id = rs.getInt("idaluno");
			String primeiroNome = rs.getString("primeiro_nome");
			String ultimoNome = rs.getString("ultimo_nome");
			String email = rs.getString("email");
			
			Aluno aluno=new Aluno(id, primeiroNome, ultimoNome, email);
			listaAlunos.add(aluno);
 		}

		} catch (Exception e) {
		
		e.printStackTrace();
		
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		if(stm!=null){
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}
		
		
		return listaAlunos;
	}
}
