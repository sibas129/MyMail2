document.getElementById("signup-form").addEventListener("submit", function(event) {
    event.preventDefault(); // prevents the form from submitting before the JavaScript code is executed

    const username = document.getElementById("username").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    // Send a POST request to the server to create a new user account
    fetch("/api/signup", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ username, email, password })
    })
        .then(response => {
            if (response.ok) {
                // If the signup was successful, redirect the user to the login page
                window.location.href = "/login.html";
            } else {
                // If the signup was not successful, display an error message to the user
                document.getElementById("signup-form").innerText = "Error signing up.";
            }
        })
        .catch(error => console.error(error));
});