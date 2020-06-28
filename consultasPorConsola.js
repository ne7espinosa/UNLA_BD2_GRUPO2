//Reemplazar fecha por ISODate en un solo documento
db.venta.updateMany({_id: "1-230"},{$set: {"fecha": new Date("2020/06/28 16:08:5")}});