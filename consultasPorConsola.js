//Reemplazar fecha por ISODate en un solo documento
// db.venta.updateMany({_id: "1-230"},{$set: {"fecha": new Date("2020/06/28 16:08:5")}});
// db.venta.updateMany({},{$set: {"fecha": new Date("2020/06/30 16:08:5")}});
// D:\Libreries\Documents\GitHub\UNLA_BD2_GRUPO2>mongo < consultasPorConsola.js
// db.orders.find().sort( { "item.category": 1, "item.type": 1 } ) PARA ORDENAR POR ATRIBUTO O POR ATRIBUTO DE DOCUMENTO HIJO
// print(tojson(document));  PARA MOSTRAR EL JSON DE UN DOCUMENTO




// CONSULTA1: Detalle y totales de ventas para la cadena completa y por sucursal, entre fechas. 
// find dates range : 
// .find({
//     fecha: {
//         $gte: ISODate("2020-06-27T00:00:00Z"),
//         $lt: ISODate("2020-06-29T00:00:00Z")
//     }
// })
use farmaciaDB;
var fechaDesde = ISODate('2020-06-29T00:00:00Z');
var fechaHasta = ISODate('2020-07-01T00:00:00Z');

var ventas = db.venta.find({
    fecha: {
        $gte: fechaDesde,
        $lt: fechaHasta
    }
}).sort({"sucursal._id": 1});
ventas.forEach(function(ven){
    var sucIdInicial = 0;
    var sucIdActual = ven.sucursal._id;
    if (sucIdActual !== sucIdInicial){
        sucIdInicial = sucIdActual;
        print("------------------------------------------------------------------------------------------");
        print("Ventas de Sucursal: " + sucIdActual );
        print("------------------------------------------------------------------------------------------");
    }
    print(tojson(ven));
});

//FIN DE CONSULTA1
