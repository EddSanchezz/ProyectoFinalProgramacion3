La agencia de espectáculos "Nombre de la Agencia" desea modernizar su proceso de venta de
boletas, ofreciendo a sus clientes una plataforma online para la compra de boletas de manera
rápida y segura. Para ello, se requiere el desarrollo de un software que permita la gestión integral
de la compra de boletas para los diferentes shows que ofrece la agencia, con las siguientes
funcionalidades.

1. Registro de usuarios: Los clientes podrán crear una cuenta en la plataforma
proporcionando información básica como nombre, dirección de correo electrónico y
contraseña.
2. Catálogo de eventos: La plataforma deberá mostrar un catálogo completo de los eventos
disponibles, incluyendo información detallada sobre cada show como nombre, fecha, lugar,
artistas/participantes, precio de las boletas (cobre, plata y oro).
3. La categoría de la boleta (cobre, plata y oro) según lo cerca que se encuentre a la tarima,
contando siempre con cobre 60% del tamaño total del teatro, 30% para plata y un 10% oro.
4. Disponibilidad de boletas: Se deberá mostrar en tiempo real la disponibilidad de boletas
para cada evento, permitiendo a los usuarios verificar la cantidad de boletas disponibles
antes de realizar la compra.
5. Taquilla virtual: La plataforma deberá habilitar una taquilla virtual que abrirá a una hora
especificada antes del inicio de la venta de boletas para cada evento. Los usuarios podrán
ingresar a la taquilla virtual por turnos de a 3 personas y realizar la compra de boletas
durante un período de tiempo determinado.
6. Proceso de compra: Los usuarios podrán seleccionar el evento de su interés, elegir la
cantidad de boletas que desean comprar y su ubicación y proceder al pago a través de
métodos de pago seguros disponibles en la plataforma (simular un pago).
7. Generación de boletos: Una vez realizada la compra, la plataforma deberá generar y enviar
electrónicamente los boletos correspondientes a la dirección de correo electrónico
proporcionada por el usuario.
8. Gestión de transacciones: El sistema deberá llevar un registro detallado de todas las
transacciones de compra realizadas, incluyendo información sobre el usuario, el evento, la
cantidad de boletas adquiridas, el método de pago utilizado, entre otros.


Criterios de aceptación del proyecto:

1. Registro de usuarios (gestionado por el usuario).
2. Registro de locaciones (gestionado por el administrador).
3. Registro de eventos (gestionado por el administrador).
4. Catálogo de eventos con información detallada (gestionado por el sistema).
5. Visualización de disponibilidad de boletas para cada evento (gestionado por el sistema).
6. Apertura de la taquilla virtual a una hora específica (gestionado por el administrador).
7. Cierre de la taquilla una hora antes del evento (gestionado por el sistema).
8. Compra de boletas por parte de los usuarios (gestionado por el usuario).
9. Cola de ingreso a la compra en línea (gestionado por el sistema).
10. Gestión de transacciones de compra (gestionado por el sistema).
11. Actualización en tiempo real de la disponibilidad de boletas (gestionado por el sistema).
12. Generación de boletos electrónicos para los usuarios que realizan compras (gestionado
por el sistema).
13. Almacenamiento de información en archivos para persistir información (gestionado por el
sistema).
14. almacenamiento de boleterías (gestionado por el sistema).

    
Requisitos tecnicos:

1. Se debe poder registrar un usuario, localizaciones y eventos.
2. se deben poder obtener todos los eventos y filtrarse por fecha de ser necesario.
3. Se deben utilizar sockets para ver la información el línea de cuantas boletas quedan de
cada categoría y cuantas personas ahi en espera en la fila.
4. Se debe poder controlar a qué hora se abre la taquilla, esta queda a discreción del
desarrollador.
5. El cierre de taquilla debe ser una hora antes del evento.
6. los usuarios pueden comprar sus boletas, como se debe hacer en tiempo real, las
seleccionadas por un usuario no pueden ser tomadas por otra persona.
7. Se debe gestionar la cola de ingreso utilizando sockets
8. Utilice hilos para que solo 3 personas puedan acceder simultáneamente a comprar sus
boletas mientras los demás siguen en espera.
9. Se debe asignar una persona a cada boleta, con su nombre e identificación. Esta persona
con la que se relaciona no debe estar registrada.
10. Las boletas se deben almacenar en una carpeta con el nombre del evento.
11. La plataforma permite la consulta de boletas con un código único para verificar su validez.
12. Al verificar las boletas el sistema debe validar si esta existe en la carpeta de boletas
compradas, si es así debe retornar la información de dicha boleta en pantalla y si no debe
informar que la boleta no existe.
13. Se debe tener registro de todas las transacciones realizadas en la aplicación. Para esto
utilice un archivo de logs en su debida carpeta de logs gestionado por día.
14. Si la existencia de boletería se acaba antes del evento, las personas en fila serán
notificadas sobre el cierre de la taquilla y cualquier persona que desee ingresar a la fila ya
no podrá hacerlo.
