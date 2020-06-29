//Reemplazar fecha por ISODate en un solo documento
// db.venta.updateMany({_id: "1-230"},{$set: {"fecha": new Date("2020/06/28 16:08:5")}})
// db.venta.updateMany({},{$set: {"fecha": new Date("2020/06/29 16:08:5")}});
// D:\Libreries\Documents\GitHub\UNLA_BD2_GRUPO2>mongo < consultasPorConsola.js
// db.orders.find().sort( { "item.category": 1, "item.type": 1 } ) PARA ORDENAR POR ATRIBUTO O POR ATRIBUTO DE DOCUMENTO HIJO
// print(tojson(document));  PARA MOSTRAR EL JSON DE UN DOCUMENTO




// CONSULTA 1: Detalle y totales de ventas para la cadena completa y por sucursal, entre fechas. 
//ventasPorSucursalIntento2('2020-06-28', '2020-06-30')
function ventasPorSucursalIntento2(fdesde, fhasta){
    var ISODesde = ISODate(fdesde);
    var ISOHasta = ISODate(fhasta);
    var productos = db.producto.find();
    //Detalle deventas por toda la cadena
    print("------------------------------------------------------------------------------------------");
    print("Ventas para la cadena completa: ");
    print("------------------------------------------------------------------------------------------");
    productos.forEach(function(prod){
        if(db.venta.find({"listaItemVenta.producto._id": prod._id}).count() > 0){
            var itemProducto = db.venta.aggregate([
                {$unwind : "$listaItemVenta"},
                {$match : {"listaItemVenta.producto._id" : prod._id, fecha: {
                    $gte: ISODesde,
                    $lt: ISOHasta
                }}},
                {$project : {_id : 0, 
                    cantidad : "$listaItemVenta.cantidad", 
                    precioUnitario : "$listaItemVenta.precioUnitario", 
                    producto : "$listaItemVenta.producto"}},
                    { $group: { _id: "$producto", 
                        cantidad: { $sum: "$cantidad" },
                        total: { $sum : { $multiply: [ "$precioUnitario", "$cantidad" ] }}
                    } }
            ]).toArray();
            print(tojson(itemProducto));        
        }
    });

    //detalles de ventas por sucursal
    var sucursales = db.sucursal.find();
    sucursales.forEach(function(suc){
        var productos = db.producto.find();
            print("------------------------------------------------------------------------------------------");
            print("Ventas de Sucursal: " + suc._id );
            print("------------------------------------------------------------------------------------------");
            productos.forEach(function(prod){
                if(db.venta.find({"listaItemVenta.producto._id": prod._id}).count() > 0){
                    var itemProducto = db.venta.aggregate([
                        {$unwind : "$listaItemVenta"},
                        {$match : {"listaItemVenta.producto._id" : prod._id, "sucursal._id": suc._id, fecha: {
                            $gte: ISODesde,
                            $lt: ISOHasta
                        }}},
                        {
                            $project : {
                                _id : 0, 
                                cantidad : "$listaItemVenta.cantidad", 
                                precioUnitario : "$listaItemVenta.precioUnitario", 
                                producto : "$listaItemVenta.producto"
                            }
                        },
                        { 
                            $group: { 
                                _id: "$producto", 
                                cantidad: { $sum: "$cantidad" },
                                total: { $sum : { $multiply: [ "$precioUnitario", "$cantidad" ] }}
                            } 
                        }
                    ]).toArray();
                    if(itemProducto.length > 0){
                        print(tojson(itemProducto)); 
                    }
                }
            });
        
    });
}
//FIN DE CONSULTA1
