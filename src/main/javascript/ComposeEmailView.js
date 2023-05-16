document.getElementById("compose-email-form").addEventListener("submit", function(event) {
    event.preventDefault(); // prevents the form from submitting before the JavaScript code is executed

    const to = document.getElementById("to").value;
    const cc = document.getElementById("cc").value;
    const bcc = document.getElementById("bcc").value;
    const subject = document.getElementById("subject").value;
    const body = document.getElementById("body").value;
    const attachment = document.getElementById("attachment").files[0];

    const formData = new FormData();
    formData.append("to", to);
    if (cc) formData.append("cc", cc);
    if (bcc) formData.append("bcc", bcc);
    formData.append("subject", subject);
    formData.append("body", body);
    if (attachment) formData.append("attachment", attachment);

    // Send a POST request to the server to send the email
    fetch("/api/send-email", {
        method: "POST",
        body: formData
    })
        .then(response => {
            if (response.ok) {
                // If the email was sent successfully, redirect the user to the inbox page
                window.location.href = "/inbox.html";
            } else {
                // If the email was not sent successfully, display an error message to the user
                document.getElementById("compose-email-form").innerText = "Error sending email.";
            }
        })
        .catch(error => console.error(error));
});