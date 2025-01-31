//index.js
(async () => {
  const db = require("database/db");
  console.log("Começou!");

  console.log("SELECT * FROM CLIENTES");
  const clientes = await db.selectCustomers();
  console.log(clientes);
})();
