
    getInitialCalculator();
var template = '<input type="button" class="button pink"  value="$value" onclick="operation(\'$key\')">';

function handleInitialization(){
    var calculator = initialData["calculator"];
    var possibleOperations = initialData["possibleOperations"];
    for(var counter in possibleOperations){
        var operation = possibleOperations[counter];
        if(operation["key"] == "Plus"){
            var templ = JSON.parse(JSON.stringify(template));
           templ =  templ.replace("$value",operation["prettyPrint"]);
           templ =  templ.replace("$key",operation["key"]);
            $("#row2").append(templ);
            possibleOperations[counter] = undefined;
        }
        if(operation["key"] == "Minus"){
            var templ = JSON.parse(JSON.stringify(template));
           templ =  templ.replace("$value",operation["prettyPrint"]);
           templ =  templ.replace("$key",operation["key"]);
            $("#row3").append(templ);
            possibleOperations[counter] = undefined;
        }
         if(operation["key"] == "Multiply"){
            var templ = JSON.parse(JSON.stringify(template));
           templ =  templ.replace("$value",operation["prettyPrint"]);
           templ =  templ.replace("$key",operation["key"]);
            $("#row4").append(templ);
            possibleOperations[counter] = undefined;
        }
         if(operation["key"] == "Devide"){
            var templ = JSON.parse(JSON.stringify(template));
           templ =  templ.replace("$value",operation["prettyPrint"]);
           templ =  templ.replace("$key",operation["key"]);
            $("#row5").append(templ);
            possibleOperations[counter] = undefined;
        }
    }
    $("#screen").val("-");
}
function doCompleteCalculation(){
   calculator = initialData["calculator"];
   operation = {"key":"Plus","value":10.0};
   var operations =  [operation];
   calculator["operations"] = operations;
   loadComplete(calculator);
}

