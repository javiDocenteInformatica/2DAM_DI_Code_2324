# Ayudas para BBDD

## Antes de conectarnos
Se pretende utilizar SQLite como bbdd. 

Para usar SQLite, simplemente tenemos que tener creado un fichero con extension '.db'.

Como buenas prácticas, deberíamos asegurarnos de que el fichero existe, y si no, crearlo, y luego añadirle las tablas pertinentes.

Para ello podemos usar el siguiente código:

	try{
	
		// Verificar si el archivo de la base de datos existe
		File databaseFile = new File("edutrack.db");
		
		boolean databaseExists = databaseFile.exists();

		// Si la base de datos no existe, crearla
		if (!databaseExists) {
		
			createDatabase(); // llama al método
			
		}
		
		System.out.println("Conexión a la base de datos establecida.");
		
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		throw new RuntimeException("Error al conectar a la base de datos SQLite", e);
	}

El método para crear la base de datos:	
	
	public void createDatabase(){
	
		// Ejecutar el script SQL directamente
		try (Statement statement = connection.createStatement()) {
		
			statement.executeUpdate(createTableScript());
			
			System.out.println("Base de datos y tabla creadas con éxito.");
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al ejecutar el script SQL", e);
		
		} finally {
			// Cerrar la conexión después de ejecutar el script
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
El método para crear las tablas en la base de datos:

	private String createTableScript() {
		// Script SQL para crear la tabla
		return "CREATE TABLE IF NOT EXISTS tasks ("
			+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "nombre TEXT NOT NULL,"
			+ "descripcion TEXT,"
			+ "fecha TEXT,"
			+ "status TEXT"
			+ ")";
    }

## Conexión a BBDD
> para conectarnos a la base de datos