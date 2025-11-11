package jp.co.sss.crud.db;

import static jp.co.sss.crud.util.ConstantMsg.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantSQL;

public class EmployeeDAO implements IEmployeeDAO {

	@Override
	public List<Employee> findAll() throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		List<Employee> employeeList = new ArrayList<Employee>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			//resultSetの結果Setがない場合は空のリストをreturn
			if (!resultSet.isBeforeFirst()) {
				return employeeList;
			}

			// 取得結果をEmployee型に変換してリストに詰める		
			while (resultSet.next()) {
				Employee employee = new Employee();

				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthDay(resultSet.getString("birthday"));
				employee.setDeptName(resultSet.getString("dept_name"));
				// emp_id, gender数値チェックするか検討する

				employeeList.add(employee);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);

		} finally {
			// resultSet, Statementをクローズ
			try {
				DBManager.close(resultSet);
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// DBとの接続を切断
		}

		// 作成した従業員リストを返す
		return employeeList;
	}

	@Override
	public List<Employee> findByEmployeeName(String searchWord) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		List<Employee> employeeList = new ArrayList<Employee>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setString(1, "%" + searchWord + "%");

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			//resultSetの結果Setがない場合は空のリストをreturn
			if (!resultSet.isBeforeFirst()) {
				return employeeList;
			}

			// 取得結果をEmployee型に変換してリストに詰める		
			while (resultSet.next()) {
				Employee employee = new Employee();

				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthDay(resultSet.getString("birthday"));
				employee.setDeptName(resultSet.getString("dept_name"));
				// emp_id, gender数値チェックするか検討する

				employeeList.add(employee);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);

		} finally {
			// resultSet, Statementをクローズ
			try {
				DBManager.close(resultSet);
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// DBとの接続を切断
		}

		// 作成した従業員リストを返す
		return employeeList;
	}

	@Override
	public List<Employee> findByDeptId(int deptIdTarget) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		List<Employee> employeeList = new ArrayList<Employee>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setInt(1, deptIdTarget);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			//resultSetの結果Setがない場合は空のリストをreturn
			if (!resultSet.isBeforeFirst()) {
				return employeeList;
			}

			// 取得結果をEmployee型に変換してリストに詰める		
			while (resultSet.next()) {
				Employee employee = new Employee();

				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthDay(resultSet.getString("birthday"));
				employee.setDeptName(resultSet.getString("dept_name"));
				// emp_id, gender数値チェックするか検討する

				employeeList.add(employee);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);

		} finally {
			// resultSet, Statementをクローズ
			try {
				DBManager.close(resultSet);
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// DBとの接続を切断
		}

		// 作成した従業員リストを返す
		return employeeList;
	}

	@Override
	public void insert(Employee employee) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			// 入力値をバインド
			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setInt(2, employee.getGender());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(employee.getBirthDay()), Types.DATE);
			preparedStatement.setInt(4, employee.getDeptId());

			// SQL文を実行
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException | ParseException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);

		} finally {
			// Statementをクローズ
			try {
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// DBとの接続を切断
		}

	}

	@Override
	public Integer update(Employee employee) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Integer result = null;

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);

			// 入力値をバインド
			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setInt(2, employee.getGender());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(employee.getBirthDay()), Types.DATE);
			preparedStatement.setInt(4, employee.getDeptId());
			preparedStatement.setInt(5, employee.getEmpId());

			// SQL文の実行(失敗時は戻り値0)
			result = preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException | ParseException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);

		} finally {
			// Statementをクローズ
			try {
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// DBとの接続を切断
		}

		return result;
	}

	@Override
	public Integer delete(Integer empIdDelete) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Integer result = null;

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);

			// 社員IDをバインド
			preparedStatement.setInt(1, empIdDelete);

			// SQL文の実行(失敗時は戻り値0)
			result = preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);

		} finally {
			// Statementをクローズ
			try {
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// DBとの接続を切断
		}
		return result;
	}

}
