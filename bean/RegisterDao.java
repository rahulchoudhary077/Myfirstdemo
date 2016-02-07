package bean;

import java.sql.*;

import mypack.MyCon;

public class RegisterDao {

	public static int register(Student s) {
		int status = 0;
		try {
			Connection con = MyCon.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into student_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, s.getScholar_no());
			ps.setString(2, s.getReg_no());
			ps.setString(3, s.getDise_code());
			ps.setString(4, s.getSssm_id());
			ps.setString(5, s.getSssm_family());
			ps.setString(6, s.getFname());
			ps.setString(7, s.getLname());
			ps.setString(8, s.getclsName());
			ps.setString(9, s.getFathername());
			ps.setString(10, s.getAnnual_income());
			ps.setString(11, s.getBusiness());
			ps.setString(12, s.getMothername());
			ps.setString(13, s.getPeraddress());
			ps.setString(14, s.getGuardianname());
			ps.setString(15, s.getGuardianaddress());
			ps.setString(16, s.getSdob());
			ps.setString(17, s.getScast());
			ps.setString(18, s.getSreligion());
			ps.setString(19, s.getScategory());
			ps.setString(20, s.getSphstatus());
			ps.setString(21, s.getSpreclass());
			ps.setString(22, s.getSprevschool());
			ps.setString(23, s.getSprevobtainmarks());
			ps.setString(24, s.getSprevtotalmarks());
			ps.setString(25, s.getSprevpercent());
			ps.setString(26, s.getSbankacno());
			ps.setString(27, s.getSifsc());
			ps.setString(28, s.getSacholdername());
			ps.setString(29, s.getSbankname());

			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static int scholarNewAssign(Student s) {
		int status = 0;
		try {
			Connection con = MyCon.getConnection();
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO scholarTblNew VALUES()");
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static int scholarExistDelete(Student s) {
		int status = 0;
		try {
			System.out.println("Hello Delete : -");
			Connection con = MyCon.getConnection();
			PreparedStatement ps = con
					.prepareStatement("DELETE FROM scholartbl WHERE scholarExist=?");
			ps.setString(1, s.getScholar_no());
			status = ps.executeUpdate();
			System.out.println("Query : -" + ps.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static int scholarNewDelete(Student s) {
		int status = 0;
		try {
			System.out.println("Hello Delete : -");
			Connection con = MyCon.getConnection();
			PreparedStatement ps = con
					.prepareStatement("DELETE FROM scholartblnew WHERE scholarNew=?");
			ps.setString(1, s.getScholar_no());
			status = ps.executeUpdate();
			System.out.println("Query : -" + ps.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

}