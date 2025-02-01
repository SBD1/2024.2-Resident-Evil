const db = require('./database/db');

db.query('select * from protagonista' , (error, result) => {
    if (error) {
        console.error(error);
        return;
    }

    console.log(result);
}
);