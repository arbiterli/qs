{
// Sample C# code accessing a sample database// You need://   A database connection//   A command to execute//   A data adapter that understands SQL databases//   A table to hold the result setnamespace DataAccess

    using System.Data;
    using System.Data.SqlClient;

	/**
	 *test connecting database 
     */
	class DataAccess
    {
        //This is your database connection:staticstring connectionString = "Initial Catalog=northwind;Data Source=(local);Integrated Security=SSPI;";
        static SqlConnection cn = new SqlConnection(connectionString); 

        // This is your command to execute:staticstring sCommand = "SELECT TOP 10 Lastname FROM Employees ORDER BY EmployeeID";

        // This is your data adapter that understands SQL databases:static SqlDataAdapter da = new SqlDataAdapter(sCommand, cn);

        /**
		 *This is your table to hold the result set:static DataTable dataTable = new DataTable();
         */
		public void acessDB(){
            try{
                cn.Open();

                // Fill the data table with select statement's query results:int recordsAffected = da.Fill(dataTable);

                if (recordsAffected > 0) {
                    foreach (DataRow dr in dataTable.Rows){
                        System.Console.WriteLine(dr[0]);
                    }
                }
            }catch (SqlException e) {
                string msg = "";
                for (int i=0; i < e.Errors.Count; i++){
                    msg += "Error #" + i + " Message: " + e.Errors[i].Message + "\n";
                }
                System.Console.WriteLine(msg);
            }finally{
                if (cn.State != ConnectionState.Closed){
                    cn.Close();
                }
            }
        }
    }
}
