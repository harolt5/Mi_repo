function myFunction() {
    var v = document.getElementById("sel").value;
    var x;
    switch (v) {
        case "Aceite":
            x = 18
            break;
        case "Arroz importado":
            x = 10
            break;
        case "Arroz nacional":
            x = 7
            break;
        case "Azucar blanca":
            x = 6
            break;
        case "Azucar prieta":
            x = 5
            break;
        case "Café":
            x = 11
            break;
        case "Chicharos":
            x = 3.50
            break;
        case "Cigarros fuertes":
            x = 17.50
            break;
        case "Cigarros suaves":
            x = 30
            break;
        case "Compotas":
            x = 0.30
            break;
        case "Detergente l":
            x = 25
            break;
        case "Frijoles blancos":
            x = 1
            break;
        case "Frijoles colorados":
            x = 0
            break;
        case "Frijoles negros":
            x = 1
            break;

        case "Jabon de baño":
            x = 9
            break;

        case "Jabon de lavar":
            x = 6
            break;
        case "Leche":
            x = 2
            break;
        case "Pasta dental":
            x = 8
            break;
        case "Sal":
            x = 7
            break;
        case "Tabacos":
            x = 5
            break;
        case "Yogurt":
            x = 5
            break;
        case "Otros":
            x = 0
            break;
        case "z":
            x = 0
            break;
        case "zz":
            x = 0
            break;
        default:
            x = 0
            break;
    }
    document.getElementById("pre").value = x;

}
