/*
When user clicks on 'Add':
1. store all the inputs into variables
2. do validation
3. calls a function from the todolistController.js to access the API to add new task to the database
*/

//Add an 'onsubmit' event listener for todolistForm to add a product
newTodoItemForm.addEventListener('submit', (event) => {

    // Prevent default action of the Form submission
    event.preventDefault();

    // Select the inputs
    const title = document.querySelector('#newTodoTitle').value;
    const description = document.querySelector('#newTodoDescription').value;
    const dateTarget = document.querySelector('#dateTarget').value; // YYYY-MM-DD, type String

    /*
        Do the Validation code here
        dateTarget has to be > today
    */
    const today = new Date();
    const targetDate = new Date(dateTarget) // convert dateTarget to Date object for comparison
    
    if (targetDate > today) {
        
        // 3. calls a function from the todolistController.js to access the API to add items to the database
        addTodo(title, description, dateTarget);
    } 
    else {
        alert("Invalid date chosen, please select a date after today");
    }

    //targetDate.toLocaleDateString("en-AU") converts targetDate to DD-MM-YYYY
});