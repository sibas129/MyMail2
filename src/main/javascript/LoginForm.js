document.getElementById("login-form").addEventListener("submit", function(event) {
    event.preventDefault(); // prevents the form from submitting before the JavaScript code is executed

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    // Send a POST request to the server to authenticate the user
    fetch("/api/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ username, password })
    })
        .then(response => {
            if (response.ok) {
                // If the login was successful, redirect the user to the inbox page
                window.location.href = "/inbox.html";
            } else {
                // If the login was not successful, display an error message to the user
                document.getElementById("login-form").innerText = "Invalid username or password.";
            }
        })
        .catch(error => console.error(error));
});