async function connect() {
  if (global.connection && global.connection.state !== "disconnected")
    return global.connection;

  const mysql = require("mysql2/promise");
  const connection = await mysql.createConnection(
    "mysql://root:1234@localhost:3306/resident_evil"
  );
  console.log("Conectou no MySQL!");
  global.connection = connection;
  return connection;
}

async function selectCustomers() {
  const conn = await connect();
  const [rows] = await conn.query("SELECT * FROM teste;");
  return rows;
}

const con = connect();
(module.exports = con), { selectCustomers };
