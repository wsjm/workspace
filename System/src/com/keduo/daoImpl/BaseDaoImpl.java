package com.keduo.daoImpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.keduo.DButil.DButil;
import com.keduo.annotation.Column;
import com.keduo.annotation.Table;
import com.keduo.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {
	//����T�е�ʵ������
	private Class<T> ct;
	public BaseDaoImpl(){
		Type  t1=this.getClass().getGenericSuperclass();
		ParameterizedType pt=(ParameterizedType)t1;
		Type t2=pt.getActualTypeArguments()[0];
        ct=(Class<T>)t2;
		System.out.println(ct);
	}
	//����id����һ����Ϣ
	public T queryById(int id) {
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		//select *  from user  where uid=?
		String sql=null;
		String idName=null;
		T  t2=null;
		DButil dButil=null;
		try{
			 dButil=new DButil();
			 con=dButil.getConnection();
			StringBuffer sb=new StringBuffer();
			sb.append("select * from ");
			//1: ��ȡ���еĶ���
			//1.1:��ȡʵ����ct
			//1.2:��ȡ���������
			Field[] fs=ct.getDeclaredFields();
			for(int i=0;i<fs.length;i++){
				Field f=fs[i];
			//1.3:��ȡ�����ϵ�ע��
				Annotation a=f.getAnnotations()[0];
				Column c=(Column)a;
			/*//1.4:��ȡע�������ֵ
				String c1=c.cname();
			//��������ƴ�ӵ�sql�������
				sb.append(c1);
				sb.append(",");*/
				if(c.isPk()){
					idName=c.cname();
				}
			}
			//String sql1=sb.toString();
			//sql=sql1.substring(0, sb.lastIndexOf(","));
			//sb=new StringBuffer(sql1);
            
			//2: ��ȡ������
            Annotation t=ct.getAnnotation(Table.class);
            Table t1=(Table)t;
            String tableName=t1.name();
			sb.append(tableName);
			sb.append(" where ");
			sb.append(idName);
			sb.append(" = ?");
			String sql1=sb.toString();
			//Ԥ���� ռλ������
			System.out.println(sql1);
			pst=con.prepareStatement(sql1);
			//pst=con.prepareStatement(sql1);
			pst.setInt(1, id);
			//ִ��sql���
			rs=pst.executeQuery();
			//���������
			if(rs.next()){
				//��������
				t2=ct.newInstance();
				//��ȡÿһ���е�ֵ 
				//��ÿ���е�ֵ�ŵ��������������ȥ
				for(int i=0;i<fs.length;i++){
					Field ff=fs[i];
					//���Զ�˽�еĽ��в���
					ff.setAccessible(true);
					Annotation a=ff.getAnnotation(Column.class);
					Column c=(Column)a;
					String columnName=c.cname();
					ff.set(t2, rs.getObject(columnName));
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dButil.close(con, pst, rs);
		}
		return t2;
		
	}
	

	public ArrayList<T> queryAll() {
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		String sql=null;
		String idName=null;
		T  t3=null;
		DButil dButil=null;
		ArrayList<T> arrayList=new ArrayList<T>();
		 dButil=new DButil();
			try {
				//�������Ӷ���
				con=dButil.getConnection();
				
				StringBuffer sb=new StringBuffer();
				//select *  from user 
				sb.append("select * from ");
				//��ȡ����
				Annotation annotation= ct.getAnnotation(Table.class);
				Table t4=(Table)annotation;
				String t5= t4.name();
				sb.append(t5);
				//Ԥ����  
				System.out.println(sb.toString());
				pst= con.prepareStatement(sb.toString());
				rs=pst.executeQuery();
				//����
				while (rs.next()) {
					//��������
					t3=ct.newInstance();
					Field[] fs=ct.getDeclaredFields();
						for(int i=0;i<fs.length;i++){
							Field ff=fs[i];
							//���Զ�˽�еĽ��в���
							ff.setAccessible(true);
							Annotation a=ff.getAnnotation(Column.class);
							Column c=(Column)a;
							String columnName=c.cname();
							ff.set(t3, rs.getObject(columnName));
						}
						arrayList.add(t3);
				}
				for (T t : arrayList) {
					System.out.println(t);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				dButil.close(con, pst, rs);
			}
			
		return arrayList;
	}

	
	@Override
	public int deleteById(int id) {
		//System.out.println("1111111111111111");
		Connection con=null;
		PreparedStatement pst=null;
		int rs=0;
		
		String sql=null;
		String idName=null;
		T  t3=null;
		DButil dButil=null;
		
		 dButil=new DButil();
			
				//�������Ӷ���
				try {
					con=dButil.getConnection();
					StringBuffer sb=new StringBuffer();
					//�ַ���ƴ��  delete * from user where id=?
					sb.append("delete from ");
					//��ȡ����
					Annotation annotation= ct.getAnnotation(Table.class);
				Table table=(Table)annotation;
				String tString=table.name();
				
				sb.append(tString);
				//��ȡ����ע��
				Field[] fs=ct.getDeclaredFields();
				for(int i=0;i<fs.length;i++){
					Field f=fs[i];
				//1.3:��ȡ�����ϵ�ע��
					Annotation a=f.getAnnotations()[0];
					Column c=(Column)a;
				/*//1.4:��ȡע�������ֵ
					String c1=c.cname();
				//��������ƴ�ӵ�sql�������
					sb.append(c1);
					sb.append(",");*/
					if(c.isPk()){
						idName=c.cname();
					}
				}
				
				
				sb.append(" where ");
				sb.append(idName);
				sb.append(" = ?");
				String  sql2=sb.toString();
				
				System.out.println(sql2);
				//Ԥ����  ռλ��
				 pst=con.prepareStatement(sb.toString());
				 //ִ��
				 pst.setInt(1, id);
				  pst.executeUpdate();
				 
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				//delect *  from user where id=? 
				
		return 0;
	}
	@Override
	public boolean updateById(T t) {
		Connection con=null;
		PreparedStatement pst=null;
		int rs=0;
		
		String sql=null;
		String idName=null;
	
		DButil dButil=null;
		 dButil=new DButil();
				//�������Ӷ���
		 try {
			con=dButil.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
					//try {
						/*StringBuffer sb=new StringBuffer();
						//ƴ��sql���
						sb.append("update ");
						//��ȡ����
						Annotation annotation= ct.getAnnotation(Table.class);
					Table an =(Table)annotation;
					String s1=an.name();
					sb.append(s1);
					sb.append(" set ");
					//��ȡ����
					Field[] fields= ct.getFields();
					
					for(int i=0;i<fields.length;i++){
						Field field1= fields[i];
						//���Զ�˽�еĽ��в���
						field1.setAccessible(true);
						Annotation a=field1.getAnnotation(Column.class);
						Column c=(Column)a;
						String columnName=c.cname();
						field1.get(t);
						sb.append(field1.getName());
						sb.append(" =? ");
					}
					
					
					//sb.append(" where ");
					//��ȡ����ע��
					Field[] fs=ct.getDeclaredFields();
					for(int i=0;i<fs.length;i++){
						Field f=fs[i];
					//1.3:��ȡ�����ϵ�ע��
						Annotation a=f.getAnnotations()[0];
						Column c=(Column)a;
					//1.4:��ȡע�������ֵ
						String c1=c.cname();
					//��������ƴ�ӵ�sql�������
						sb.append(c1);
						sb.append(",");
						if(c.isPk()){
							idName=c.cname();
						}
					}
					sb.append(idName);
					sb.append(" = ? ");
					System.out.println(sb.toString());
					//Ԥ����
					 pst=con.prepareStatement(sb.toString());
					 //pst.setInt(1, id);
					//ִ��
					 pst.setObject(1, t);
					 pst.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
		//sql1���ڴ�����շ��ص�sql���
	        StringBuilder sql1 = new StringBuilder("insert into ");
	        //tableName���ڴ��sql1����б�������
	        StringBuilder tableName;
	        //columnName���ڴ��sql1�����ֶβ���
	        StringBuilder columnName = new StringBuilder("(");
	        //values���ڴ��sql1����еĸ�ֵ����
	        StringBuilder values = new StringBuilder("(");
	        //��ȡ����user��class����
	        Class clazz = t.getClass();
	        //�жϸ�User���Ƿ���@Tableע��
	        boolean isTable = clazz.isAnnotationPresent(Table.class);
	        if(isTable) {
	            //��ȡUser��@Tableע���ֵvalue����ֵ���Ƕ���ΪUser��ı�����
	            Table t1 = (Table) clazz.getAnnotation(Table.class);
	            tableName = new StringBuilder(t1.name());
	            //ƴ�ӱ���
	            sql1.append(tableName+" ");
	            //��ȡuser����������б�
	            Field[] fieldList = clazz.getDeclaredFields();
	            //���������б��ֱ��ó������б��б�@Columnע������ԣ�����ȡ���Ե�ֵ
	            for(int i=0;i<fieldList.length;i++){
	                Field f =  fieldList[i];
	                boolean isColumn = f.isAnnotationPresent(Column.class);
	                if(!isColumn){
	                    continue;
	                }
	                Column column = f.getAnnotation(Column.class);
	                 f.setAccessible(true); 
	                try {
						Object columnValue = f.get(t);
						 if(i==fieldList.length-1){
			                    columnName.append(column.cname()+") VALUES ");
			                    values.append("'"+columnValue+"')");
			                    sql1.append(columnName);
			                    sql1.append(values);
			                    continue;
			                }
			                columnName.append(column.cname()+", ");
			                values.append("'"+columnValue+"',");
			                System.out.println(sql1.toString());
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	               
	            }
	        }
			return true;

				
		
	}
	@Override
	public boolean add(T t) {
		Connection con=null;
		PreparedStatement pst=null;
		int rs=0;
		
		String sql=null;
		String idName=null;
	
		DButil dButil=null;
		try {
			 dButil=new DButil();
			//��ȡ����
			con=dButil.getConnection();
			//ƴ��sql���
			StringBuffer sb= new StringBuffer();
			sb.append("insert into ");
			//��ȡ����
			Annotation annotation= ct.getAnnotation(Table.class);
			Table table=(Table)annotation;
			String tString= table.name();
			sb.append(tString);
			sb.append(" (");
			//��ȡ�����ϵ�ע�� �ٻ�ȡ�ֶ�
			Field[] fields= ct.getDeclaredFields();
			
			ArrayList<String> arrayList=new ArrayList();
			for(int i=0;i<fields.length;i++){
				Field field1= fields[i];
				//�����Դ洢��������ȥ
				arrayList.add(field1.getName());
				
				/*Column f2= field1.getAnnotation(Column.class);
				field1.setAccessible(true);
				Object t1= field1.get(t);
				System.out.println(t1.toString());
				sb.append(f2.cname()+" , "+") values (");
				sb.append("'"+t1+"' ,");*/
				
			}
			
			sb.append(arrayList+" ) values (");
			//��ȡע���ֵ
			Annotation annotation2= fields[0].getAnnotation(Column.class);
			Column column=(Column)annotation2;
			System.out.println(column.cname());
			
			sb.append(column.cname()+")");
			
			String string= sb.toString().replace("[", " ");
			String string1= string.replace("]", " ");
			
			System.out.println(string1);
			pst=con.prepareStatement(string1);
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return true;
	}

}
