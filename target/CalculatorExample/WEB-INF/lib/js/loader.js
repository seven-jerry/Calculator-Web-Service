
var initialData;
var calculator;
function getInitialCalculator(){
    $.ajax({
        type: "POST",
        url: "http://192.168.0.100:8080/CalculatorExample/calculator/api/initialize",
        // The key needs to match your method's input parameter (case-sensitive).
        dataType: "json",
        success: function(data){
            initialData = data;
            handleInitialization();
            calculator = initialData["calculator"];
            loadComplete();
        },
        failure: function(errMsg) {
            alert(errMsg);
        }
    });
}

function loadComplete(){

    $.ajax({
        beforeSend: function(xhrObj){
                xhrObj.setRequestHeader("Content-Type","application/json");
                xhrObj.setRequestHeader("Accept","application/json");
        },
        type: "POST",
        url: "http://192.168.0.100:8080/CalculatorExample/calculator/api/completeCalculation",
        processData: false,
        data: JSON.stringify(calculator),
        dataType: "json",
        success: function(json){
        }
});


}
