// Retrieve the user's inbox from the server using a GET request and display the emails in the view
fetch("/api/inbox")
    .then(response => response.json())
    .then(emails => {
        const emailList = document.querySelector(".email-list");

        // Loop through each email in the inbox and create a list item for it
        emails.forEach(email => {
            const li = document.createElement("li");

            li.innerHTML = `
            <h2>${email.sender}</h2>
            <p>${email.subject}</p>
            <p>${email.body}</p>
            <p>${email.timestamp}</p>
         `;

            // Add an event listener to each list item to allow the user to open the email
            li.addEventListener("click", function() {

            });

            emailList.appendChild(li);
        });
    })
    .catch(error => console.error(error));