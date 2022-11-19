var mysql = require("mysql2");

var con = mysql.createConnection({
  host: "localhost",
  user: "root",
  port: 3307,
  password: "",
  database: "mydb"
});

con.connect(function(err) {
    if (err) throw err;
    console.log("Connected!");

    // Create Table
    // var sql = "CREATE TABLE student (rollno int(6), name varchar(20), branch varchar(20))";
    // con.query(sql, function (err, result) {
    //     if (err) throw err;
    //     console.log("Table created");
    // });

    // Inserting data
    // var sql = "INSERT INTO student (rollno, name, branch) VALUES (1, 'China', 'Fullstack Developer')";
    // con.query(sql, function (err, result) {
    //     if (err) throw err;
    //     console.log("Record inserted");
    // });

    // Altering table
    // var sql = "ALTER TABLE student ADD COLUMN class VARCHAR(20)"
    // con.query(sql, function (err, result) {
    //     if (err) throw err;
    //     console.log("Column added");
    // });

    // Delete row
    // var sql = "DELETE FROM student WHERE rollno = 1";
    // con.query(sql, function (err, result) {
    //     if (err) throw err;
    //     console.log("Number of records deleted: " + result.affectedRows);
    // });

    // Drop Coloumn
    // var sql = "ALTER TABLE student DROP COLUMN branch"
    // con.query(sql, function (err, result) {
    //     if (err) throw err;
    //     console.log("Column deleted");
    // });

    // Change datatype
    // var sql = "ALTER TABLE student MODIFY COLUMN rollno int(8)"
    // con.query(sql, function (err, result) {
    //     if (err) throw err;
    //     console.log("Altered column's datatype");
    // });

    // Delete all data
    // var sql = "DELETE FROM student";
    // con.query(sql, function (err, result) {
    //     if (err) throw err;
    //     console.log("All records deleted. " + result.affectedRows + " records were deleted");
    // });

    // Delete the table
    // var sql = "DROP TABLE student";
    // con.query(sql, function (err, result) {
    //   if (err) throw err;
    //   console.log("Table deleted");
    // });
  });