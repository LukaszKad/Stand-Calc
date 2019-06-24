document.addEventListener("DOMContentLoaded", function () {

    var userInfo = document.querySelector("#userInfo");
    var userData = document.querySelector("#userData");
    var companyInfo = document.querySelector("#companyInfo");
    var companyData = document.querySelector("#companyData")

    userData.style.display = "none";
    companyData.style.display = "none";

    userInfo.addEventListener("input", function () {

        if(this.checked){
            userData.style.display = "block";
            companyData.style.display ="none";
        } else {
            userData.style.display = "none";
        }
    })

    companyInfo.addEventListener("input", function () {

        if(this.checked){
            companyData.style.display = "block";
            userData.style.display= "none";
        } else {
            companyData.style.display = "none";
        }
    })


});