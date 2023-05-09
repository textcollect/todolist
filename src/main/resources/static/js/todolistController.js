/*
    ProductController perform action to the products to be displayed

    (1) Display all products to be retrieved from the back-end
    (2) Add product to the product list (send the new project to the back-end)
    --- edit an existing product detail
    -- remove an existing product from the product list
*/

//development APIs
const addAPI = 'http://localhost:8080/todo/add';
const displayAPI = 'http://localhost:8080/todo/all';

// Initialise an empty array that will be used to store the data received from displayAPI ('/all' api)
let todolistController = [];

function displayTodoList() {

    //fetch data from database using the REST API endpoint from Spring Boot
    // GET http method is the default, so no need to specify the specifics for GET
    fetch(displayAPI)
        .then((resp) => resp.json())
        .then(function (data) {
            console.log("2. receive data")
            console.log(data);

            data.forEach(function (todolist, index) {
                const todolistObj = {
                    id: todolist.id,
                    title: todolist.title,
                    description: todolist.description,
                    targetDate: todolist.targetDate
                };

                // this array contains 3 items from the database(received via the '/all' API)
                todolistController.push(todolistObj);
            });

            // calls the function to display all the 3 objects from the todolistController array
            // function is declared below
            renderTodolistPage();

            //console.log(`${typeof todolistController[0].targetDate}`); //String
        })
        .catch(function (error) {
            console.log(error);
        });
}


//(3)  Display all customers when user launch the customer.html page
//const displayProduct = () => {
function renderTodolistPage() {

    let display = "";
    
    display += `
            <table class="table table-bordered table-striped table-sm">
                <thead>
                    <tr class="table-success">
                        <th style="text-align: center;">Title</th>
                        <th style="text-align: center;">Description</th>
                        <th style="text-align: center;">Target Date</th>
                    </tr>
                </thead>
                <tbody>`;
            //         <tr>
            //             <td>Run Errands</td>
            //             <td>To buy...</td>
            //             <td>05/06/2021</td>
            //         </tr>
            //         <tr>
            //             <td>JFSD Porject Task</td>
            //             <td>Complete Frontend and Backend...</td>
            //             <td>28/05/2021</td>
            //         </tr>
            //     </tbody>
            // </table>`;

    for (let i = 0; i < todolistController.length; i++) {
        
        // Date passed from backend is a String in YYYY-MM-DD format
        //require to be in DD/MM/YYYY format. So, declare new array to store as Date format 
        //then convert to required DD/MM/YYYY String format
        var newDates=[];
        newDates[i] = new Date(todolistController[i].targetDate);

        display += `
        <tr>
                    <td>${todolistController[i].title}</td>
                    <td>${todolistController[i].description}</td>
                    <td>${newDates[i].toLocaleDateString("en-AU")}</td>
                </tr>`;
    }

    // Close the table
    display += `</tbody></table>`;

    document.querySelector("#todolist-table").innerHTML = display;

} //End of renderTodolistPage function



//4) Add new todo entry to the TODO list when user clicks on the submit button from the todolistForm.html
function addTodo(title, description, targetDate) {
    
    // formData is an Object provided by the Browser API for us to send the data over to the backend
    // Make sure names in the append matches the names from the TodoListController java
    // no need to match sequence
    const formData = new FormData();
    formData.append('title', title);
    formData.append('description', description);
    formData.append('targetDate', targetDate);

    // Call the addAPI
    fetch(addAPI, {
        method: 'POST',
        body: formData
    })
        .then(function (response) {
            console.log(response.status); // Will show you the status - 200 OK, 500, 404
            if (response.ok) {
                alert("Successfully Added New Task To-Do!")
                
                // Refresh the page
                window.location.reload()
            }
            else {
                alert("Something went wrong. Please try again")
            }
        })
        .catch((error) => {
            console.error('Error:', error);
            alert("Error adding task")
        });
}






