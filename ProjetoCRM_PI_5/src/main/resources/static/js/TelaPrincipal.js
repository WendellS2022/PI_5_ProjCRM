function Redirecionar(setor){
window.location.href = "/formulario?setor="+setor;
}

function RedirecionarGerencia(){
    window.location.href = "/gerenciamento";

}
//
// function logout() {
//     // Since we're not sending any data for logout, we'll prepare the headers
//     let headers = new Headers();
//     headers.append("Content-Type", "application/x-www-form-urlencoded");
//
//     // Prepare the request options
//     let requestOptions = {
//         method: 'POST',
//         headers: headers,
//         credentials: 'same-origin', // Include cookies in the request. Useful for session-based authentication
//         body: '' // No body content is necessary for a logout request, but you could add parameters here
//     };
//
//     // Use the fetch API to send the request
//     fetch("/logout", requestOptions)
//         .then(response => {
//             if (response.ok) {
//                 // Request was successful
//                 console.log("Logged out successfully");
//                 // Optionally, redirect the user or handle the logout success case
//                 // window.location.href = "/login"; for example
//             } else {
//                 // Server responded with an HTTP error code
//                 console.error("Logout failed with status: " + response.status);
//             }
//         })
//         .catch(error => {
//             // Network error or another issue with the fetch call
//             console.error("Logout failed with error: " + error);
//         });
// }
