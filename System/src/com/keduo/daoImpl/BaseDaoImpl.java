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
	//泛型T中的实际类型
	private Class<T> ct;
	public BaseDaoImpl(){
		Type  t1=this.getClass().getGenericSuperclass();
		ParameterizedType pt=(ParameterizedType)t1;
		Type t2=pt.getActualTypeArguments()[0];
        ct=(Class<T>)t2;
		System.out.println(ct);
	}
	//根据id查找一个信息
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
			//1: 获取所有的段名
			//1.1:获取实际类ct
			//1.2:获取该类的属性
			Field[] fs=ct.getDeclaredFields();
			for(int i=0;i<fs.length;i++){
				Field f=fs[i];
			//1.3:获取属性上的注解
				Annotation a=f.getAnnotations()[0];
				Column c=(Column)a;
			/*//1.4:获取注解的属性值
				String c1=c.cname();
			//把列名字拼接到sql语句里面
				sb.append(c1);
				sb.append(",");*/
				if(c.isPk()){
					idName=c.cname();
				}
			}
			//String sql1=sb.toString();
			//sql=sql1.substring(0, sb.lastIndexOf(","));
			//sb=new StringBuffer(sql1);
            
			//2: 获取表名字
            Annotation t=ct.getAnnotation(Table.class);
            Table t1=(Table)t;
            String tableName=t1.name();
			sb.append(tableName);
			sb.append(" where ");
			sb.append(idName);
			sb.append(" = ?");
			String sql1=sb.toString();
			//预编译 占位符设置
			System.out.println(sql1);
			pst=con.prepareStatement(sql1);
			//pst=con.prepareStatement(sql1);
			pst.setInt(1, id);
			//执行sql语句
			rs=pst.executeQuery();
			//遍历结果集
			if(rs.next()){
				//创建对象
				t2=ct.newInstance();
				//获取每一个列的值 
				//把每个列的值放到对象的属性上面去
				for(int i=0;i<fs.length;i++){
					Field ff=fs[i];
					//可以对私有的进行操作
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
				//创建连接对象
				con=dButil.getConnection();
				
				StringBuffer sb=new StringBuffer();
				//select *  from user 
				sb.append("select * from ");
				//获取表名
				Annotation annotation= ct.getAnnotation(Table.class);
				Table t4=(Table)annotation;
				String t5= t4.name();
				sb.append(t5);
				//预编译  
				System.out.println(sb.toString());
				pst= con.prepareStatement(sb.toString());
				rs=pst.executeQuery();
				//遍历
				while (rs.next()) {
					//创建对象
					t3=ct.newInstance();
					Field[] fs=ct.getDeclaredFields();
						for(int i=0;i<fs.length;i++){
							Field ff=fs[i];
							//可以对私有的进行操作
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
			
				//创建连接对象
				try {
					con=dButil.getConnection();
					StringBuffer sb=new StringBuffer();
					//字符串拼接  delete * from user where id=?
					sb.append("delete from ");
					//获取表名
					Annotation annotation= ct.getAnnotation(Table.class);
				Table table=(Table)annotation;
				String tString=table.name();
				
				sb.append(tString);
				//获取属性注解
				Field[] fs=ct.getDeclaredFields();
				for(int i=0;i<fs.length;i++){
					Field f=fs[i];
				//1.3:获取属性上的注解
					Annotation a=f.getAnnotations()[0];
					Column c=(Column)a;
				/*//1.4:获取注解的属性值
					String c1=c.cname();
				//把列名字拼接到sql语句里面
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
				//预编译  占位符
				 pst=con.prepareStatement(sb.toString());
				 //执行
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
				//创建连接对象
		 try {
			con=dButil.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
					//try {
						/*StringBuffer sb=new StringBuffer();
						//拼接sql语句
						sb.append("update ");
						//获取表名
						Annotation annotation= ct.getAnnotation(Table.class);
					Table an =(Table)annotation;
					String s1=an.name();
					sb.append(s1);
					sb.append(" set ");
					//获取属性
					Field[] fields= ct.getFields();
					
					for(int i=0;i<fields.length;i++){
						Field field1= fields[i];
						//可以对私有的进行操作
						field1.setAccessible(true);
						Annotation a=field1.getAnnotation(Column.class);
						Column c=(Column)a;
						String columnName=c.cname();
						field1.get(t);
						sb.append(field1.getName());
						sb.append(" =? ");
					}
					
					
					//sb.append(" where ");
					//获取属性注解
					Field[] fs=ct.getDeclaredFields();
					for(int i=0;i<fs.length;i++){
						Field f=fs[i];
					//1.3:获取属性上的注解
						Annotation a=f.getAnnotations()[0];
						Column c=(Column)a;
					//1.4:获取注解的属性值
						String c1=c.cname();
					//把列名字拼接到sql语句里面
						sb.append(c1);
						sb.append(",");
						if(c.isPk()){
							idName=c.cname();
						}
					}
					sb.append(idName);
					sb.append(" = ? ");
					System.out.println(sb.toString());
					//预编译
					 pst=con.prepareStatement(sb.toString());
					 //pst.setInt(1, id);
					//执行
					 pst.setObject(1, t);
					 pst.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
		//sql1用于存放最终返回的sql语句
	        StringBuilder sql1 = new StringBuilder("insert into ");
	        //tableName用于存放sql1语句中表名部分
	        StringBuilder tableName;
	        //columnName用于存放sql1语句的字段部分
	        StringBuilder columnName = new StringBuilder("(");
	        //values用于存放sql1语句中的赋值部分
	        StringBuilder values = new StringBuilder("(");
	        //获取对象user的class对象
	        Class clazz = t.getClass();
	        //判断该User类是否有@Table注解
	        boolean isTable = clazz.isAnnotationPresent(Table.class);
	        if(isTable) {
	            //获取User类@Table注解的值value，该值我们定义为User表的表名称
	            Table t1 = (Table) clazz.getAnnotation(Table.class);
	            tableName = new StringBuilder(t1.name());
	            //拼接表名
	            sql1.append(tableName+" ");
	            //获取user对象的属性列表
	            Field[] fieldList = clazz.getDeclaredFields();
	            //遍历属性列表，分别拿出属性列表中被@Column注解的属性，并获取属性的值
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
			//获取连接
			con=dButil.getConnection();
			//拼接sql语句
			StringBuffer sb= new StringBuffer();
			sb.append("insert into ");
			//获取表名
			Annotation annotation= ct.getAnnotation(Table.class);
			Table table=(Table)annotation;
			String tString= table.name();
			sb.append(tString);
			sb.append(" (");
			//获取属性上的注解 再获取字段
			Field[] fields= ct.getDeclaredFields();
			
			ArrayList<String> arrayList=new ArrayList();
			for(int i=0;i<fields.length;i++){
				Field field1= fields[i];
				//将属性存储到集合中去
				arrayList.add(field1.getName());
				
				/*Column f2= field1.getAnnotation(Column.class);
				field1.setAccessible(true);
				Object t1= field1.get(t);
				System.out.println(t1.toString());
				sb.append(f2.cname()+" , "+") values (");
				sb.append("'"+t1+"' ,");*/
				
			}
			
			sb.append(arrayList+" ) values (");
			//获取注解的值
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
