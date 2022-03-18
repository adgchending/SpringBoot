import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class sry {
	public Connection con;

	public Connection getdrgsCon(){
		Connection con = null;
		try {
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(driver);
			con= DriverManager.getConnection("jdbc:sqlserver://175.6.27.49:11433;DatabaseName=trasen_drgs_sry", "sa", "1q2w3e4r5tQ!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public Connection getBaCon(){
		Connection con = null;
		try {
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(driver);
			con  = DriverManager.getConnection("jdbc:sqlserver://192.168.10.28:1433;DatabaseName=trasen_drgs_sry", "wzsb", "rmyywzsb");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}


	//175库
	public void GetFeeto_His(){

//		V_pat_fee fee  = new V_pat_fee();
		System.out.println("----2.1----");
		try {

			String sql = "  select                                     "+
					"  c.inpatient_id as ID,                                  "+
					"  a.out_date,                                            "+
					"  b.inpatient_no,                                        "+
					"  b.name,                                                "+
					"  a38 feeBed,                                            "+
					"  a06+a43+a18+a34+a17	feeHl,                            "+
					"  a11	feeXy,                                            "+
					"  0	feeZcy,                                           "+
					"  a28	feeZc,                                            "+
					"  a10	feeFs,                                            "+
					"  a29+a30+a44	feeHy,                                    "+
					"  a15+a19+a21+a23+a24+a25+a14+a22+a26+a45	feeSy,        "+
					"  a05+a07+a16+a19+a27+a31+a13	feeSx,                    "+
					"  a08+a37	feeZl,                                        "+
					"  a32	feeOther2,                                        "+
					"  0	feeSh,                                            "+
					"  0	feeJs,                                            "+
					"  a33	feeJc,                                            "+
					"  a01+a04	feeMz,                                        "+
					"  a02 	feeYe,                                            "+
					"  a03	feePc,                                            "+
					"  a12	feeOther1,                                        "+
					"  0	feeOther3,                                        "+
					" 0	charge01,                                             "+
					" 0	charge02,                                             "+
					" 0	charge03,                                             "+
					" 0	charge04,                                             "+
					" 0	charge05,                                             "+
					"  a09	charge06,                                         "+
					"  a35+a36+a42	charge07,                                 "+
					" 0	charge08,                                             "+
					" 0	charge09,                                             "+
					" 0	charge10,                                             "+
					" a37	charge11,                                             "+
					" a08	charge12,                                             "+
					" 0	charge13,                                             "+
					" 0	charge14,                                             "+
					" 0	charge15,                                             "+
					" 0	charge16,                                             "+
					" 0	charge17,                                             "+
					" 0	charge18,                                             "+
					" 0	charge19,                                             "+
					" 0	charge20,                                             "+
					" 0	charge21,                                             "+
					" 0	charge22,                                             "+
					" a01+a02+a03+a04+a05+a06+a07+a08+a09+a10+a11+a12+a13+a14+a15+a16+a17+a18+a19+a20+a21+a22+a23+a24+a25+a26+a27+a28+a29+a30+a31+a32+a33+a34+a35+a36+a37+a38+a39+a40+a41+a42+a43+a44+a45+a99 as feeSum,"+
					" NFEE - YB_FEE as feeSumPay              "+
					"    from (                 "+
					"  select inpatient_id,     "+
					"  max(case statitem_code when '01' then itemvalues else 0 end) a01,  "+
					"  max(case statitem_code when '02' then itemvalues else 0 end) a02,  "+
					"  max(case statitem_code when '03' then itemvalues else 0 end) a03,  "+
					"  max(case statitem_code when '04' then itemvalues else 0 end) a04,  "+
					"  max(case statitem_code when '05' then itemvalues else 0 end) a05,  "+
					"  max(case statitem_code when '06' then itemvalues else 0 end) a06,  "+
					"  max(case statitem_code when '07' then itemvalues else 0 end) a07,  "+
					"  max(case statitem_code when '08' then itemvalues else 0 end) a08,  "+
					"  max(case statitem_code when '09' then itemvalues else 0 end) a09,  "+
					"  max(case statitem_code when '10' then itemvalues else 0 end) a10,  "+
					"  max(case statitem_code when '11' then itemvalues else 0 end) a11,  "+
					"  max(case statitem_code when '12' then itemvalues else 0 end) a12,  "+
					"  max(case statitem_code when '13' then itemvalues else 0 end) a13,  "+
					"  max(case statitem_code when '14' then itemvalues else 0 end) a14,  "+
					"  max(case statitem_code when '15' then itemvalues else 0 end) a15,  "+
					"  max(case statitem_code when '16' then itemvalues else 0 end) a16,  "+
					"  max(case statitem_code when '17' then itemvalues else 0 end) a17,  "+
					"  max(case statitem_code when '18' then itemvalues else 0 end) a18,  "+
					"  max(case statitem_code when '19' then itemvalues else 0 end) a19,  "+
					"  max(case statitem_code when '20' then itemvalues else 0 end) a20,  "+
					"  max(case statitem_code when '21' then itemvalues else 0 end) a21,  "+
					"  max(case statitem_code when '22' then itemvalues else 0 end) a22,  "+
					"  max(case statitem_code when '23' then itemvalues else 0 end) a23,  "+
					"  max(case statitem_code when '24' then itemvalues else 0 end) a24,  "+
					"  max(case statitem_code when '25' then itemvalues else 0 end) a25,  "+
					"  max(case statitem_code when '26' then itemvalues else 0 end) a26,  "+
					"  max(case statitem_code when '27' then itemvalues else 0 end) a27,  "+
					"  max(case statitem_code when '28' then itemvalues else 0 end) a28,  "+
					"  max(case statitem_code when '29' then itemvalues else 0 end) a29,  "+
					"  max(case statitem_code when '30' then itemvalues else 0 end) a30,  "+
					"  max(case statitem_code when '31' then itemvalues else 0 end) a31,  "+
					"  max(case statitem_code when '32' then itemvalues else 0 end) a32,  "+
					"  max(case statitem_code when '33' then itemvalues else 0 end) a33,  "+
					"  max(case statitem_code when '34' then itemvalues else 0 end) a34,  "+
					"  max(case statitem_code when '35' then itemvalues else 0 end) a35,  "+
					"  max(case statitem_code when '36' then itemvalues else 0 end) a36,  "+
					"  max(case statitem_code when '37' then itemvalues else 0 end) a37,  "+
					"  max(case statitem_code when '38' then itemvalues else 0 end) a38,  "+
					"  max(case statitem_code when '39' then itemvalues else 0 end) a39,  "+
					"  max(case statitem_code when '40' then itemvalues else 0 end) a40,  "+
					"  max(case statitem_code when '41' then itemvalues else 0 end) a41,  "+
					"  max(case statitem_code when '42' then itemvalues else 0 end) a42,  "+
					"  max(case statitem_code when '43' then itemvalues else 0 end) a43,  "+
					"  max(case statitem_code when '44' then itemvalues else 0 end) a44,  "+
					"  max(case statitem_code when '45' then itemvalues else 0 end) a45,  "+
					"  max(case when cast(statitem_code as int) > 45 then itemvalues else 0 end) a99      "+
					"  from (select a.inpatient_id,a.statitem_code,sum(itemvalues) as itemvalues from     "+
					"  zy_dischargelist a,zy_inpatient b                                                  "+
					"  where a.inpatient_id=b.inpatient_id                                                "+
					"  and b.out_date > ? and b.out_date < ?                                              "+
					"  group by a.inpatient_id,a.statitem_code) group by inpatient_id ) c                 "+
					"  left join zy_inpatient a on c.inpatient_id = a.inpatient_id                        "+
					"  left join base_patient_property b on a.patient_id = b.patient_id "+
					" left join zy_discharge d on d.inpatient_id=c.inpatient_id and cz_flag=0 ";
			// " where a.patient_id='727604' ";

			String sqlba = " UPDATE pat_fee SET FEE_ZC = ?,"+
					" FEE_HL=?, "+
					" FEE_ZL=?, "+
					" FEE_JC=?, "+
					" FEE_SH=?, "+
					" FEE_SX=?, "+
					" FEE_XY=?, "+
					" FEE_SY=?, "+
					" FEE_ZCY=?,"+
					" FEE_FS=?,"+
					" FEE_MZ=?,"+
					" FEE_OTHER_1=?,"+
					" FEE_OTHER_2=?,"+
					" FEE_OTHER_3=?,"+
					" FEE_BED=?,"+
					" FEE_HY=?,"+
					" FEE_PC=?,"+
					" FEE_YE=?,"+
					" FEE_JS=?,"+
					" FEE_SUM=?,"+
					" CHARGE_01=?, "+
					" CHARGE_02=?, "+
					" CHARGE_03=?, "+
					" CHARGE_04=?, "+
					" CHARGE_05=?, "+
					" CHARGE_06=?, "+
					" CHARGE_07=?, "+
					" CHARGE_08=?, "+
					" CHARGE_09=?, "+
					" CHARGE_10=?, "+
					" CHARGE_11=?, "+
					" CHARGE_12=?, "+
					" CHARGE_13=?, "+
					" CHARGE_14=?, "+
					" CHARGE_15=?, "+
					" CHARGE_16=?, "+
					" CHARGE_17=?, "+
					" CHARGE_18=?, "+
					" CHARGE_19=?, "+
					" CHARGE_20=?, "+
					" CHARGE_21=?, "+
					" CHARGE_22=?,  "+
					" fee_sum_pay=?  "+
					"from pat_enter_dept d,pat_index i,pat_fee f where "
					+ "d.patient_id=i.patient_id and d.visit_id=i.visit_id"
					+ " and f.patient_id = d.patient_id and f.visit_id=d.visit_id and fee_sum<2 and d.hosp_code = 1"+
		        	/*" FROM dbo.pat_enter_dept b left join  pat_index  c on b.patient_id = c.patient_id and b.visit_id=c.visit_id"+
		        	" WHERE dbo.pat_fee.patient_id = b.patient_id "+
		        	" AND pat_fee.visit_id =b.visit_id  "+*/
					" AND  CONVERT(VARCHAR(10),d.out_date,120)= CONVERT(VARCHAR(10),?,120)  "+
					" AND i.unique_id = ?";


			System.out.println("----2.2----");
			System.out.println(sql);
			System.out.println(sqlba);
			PreparedStatement stmt = getdrgsCon().prepareStatement(sql);
			PreparedStatement stmt2 = getBaCon().prepareStatement(sqlba);

			stmt.setString(1, "2019-12-01 00:00:00");
			stmt.setString(2, "2019-12-31 23:59:59");
			ResultSet rs = stmt.executeQuery();
			System.out.println("一共"+rs.getRow());
			while (rs.next()) {
				stmt2.setDouble(1, rs.getDouble("feeZc"));
				stmt2.setDouble(2, rs.getDouble("feeHl"));
				stmt2.setDouble(3, rs.getDouble("feeZl"));
				stmt2.setDouble(4, rs.getDouble("feeJc"));
				stmt2.setDouble(5, rs.getDouble("feeSh"));
				stmt2.setDouble(6, rs.getDouble("feeSx"));
				stmt2.setDouble(7, rs.getDouble("feeXy"));
				stmt2.setDouble(8, rs.getDouble("feeSy"));
				stmt2.setDouble(9, rs.getDouble("feeZcy"));
				stmt2.setDouble(10, rs.getDouble("feeFs"));
				stmt2.setDouble(11, rs.getDouble("feeMz"));
				stmt2.setDouble(12, rs.getDouble("feeOther1"));
				stmt2.setDouble(13, rs.getDouble("feeOther2"));
				stmt2.setDouble(14, rs.getDouble("feeOther3"));
				stmt2.setDouble(15, rs.getDouble("feeBed"));
				stmt2.setDouble(16, rs.getDouble("feeHy"));
				stmt2.setDouble(17, rs.getDouble("feePc"));
				stmt2.setDouble(18, rs.getDouble("feeYe"));
				stmt2.setDouble(19, rs.getDouble("feeJs"));
				stmt2.setDouble(20, rs.getDouble("feeSum"));
				stmt2.setDouble(21, rs.getDouble("charge01"));
				stmt2.setDouble(22, rs.getDouble("charge02"));
				stmt2.setDouble(23, rs.getDouble("charge03"));
				stmt2.setDouble(24, rs.getDouble("charge04"));
				stmt2.setDouble(25, rs.getDouble("charge05"));
				stmt2.setDouble(26, rs.getDouble("charge06"));
				stmt2.setDouble(27, rs.getDouble("charge07"));
				stmt2.setDouble(28, rs.getDouble("charge08"));
				stmt2.setDouble(29, rs.getDouble("charge09"));
				stmt2.setDouble(30, rs.getDouble("charge10"));
				stmt2.setDouble(31, rs.getDouble("charge11"));
				stmt2.setDouble(32, rs.getDouble("charge12"));
				stmt2.setDouble(33, rs.getDouble("charge13"));
				stmt2.setDouble(34, rs.getDouble("charge14"));
				stmt2.setDouble(35, rs.getDouble("charge15"));
				stmt2.setDouble(36, rs.getDouble("charge16"));
				stmt2.setDouble(37, rs.getDouble("charge17"));
				stmt2.setDouble(38, rs.getDouble("charge18"));
				stmt2.setDouble(39, rs.getDouble("charge19"));
				stmt2.setDouble(40, rs.getDouble("charge20"));
				stmt2.setDouble(41, rs.getDouble("charge21"));
				stmt2.setDouble(42, rs.getDouble("charge22"));
				stmt2.setString(43, rs.getString("feeSumPay"));
				stmt2.setString(44, rs.getString("out_date"));
				stmt2.setString(45, rs.getString("inpatient_no"));
				System.out.println("当前修改的住院号是："+rs.getString("inpatient_no")+"当前修改的费用是："+rs.getDouble("feeSum"));
				int i = stmt2.executeUpdate();
				if(i==0){
					System.out.println(rs.getString("inpatient_no")+"失败");
				}else {
					System.out.println(rs.getString("inpatient_no")+"成功");
				}


			}
			System.out.println("完成");
			rs.close();
		}  catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("---1-----");
		sry fee = new sry();
		System.out.println("开始");
		fee.GetFeeto_His();
		System.out.println("结束");
	}
}
