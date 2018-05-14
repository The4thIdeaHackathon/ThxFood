const app = require('../index');

console.log("app :", app);
app.listen(3001, () => (
    console.log("Running")
))

