class LinkedList {
    Node head;//Referencia al primer nodo de la lista

    public void add(int data) {
        Node nuevoNodo = new Node(data);
        
        //Si la lista está vacía, el nuevo nodo se convierte en la cabeza
        if (head == null) {
            head = nuevoNodo;
        } else {
            //Recorremos hasta el último nodo y agregamos el nuevo
            Node actual = head;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }   
    public void agregar_primero(int data) {
        Node nuevoNodo = new Node(data);
        nuevoNodo.siguiente = head;//El nuevo nodo apunta a la antigua cabeza
        head = nuevoNodo;//El nuevo nodo se convierte en la nueva cabeza
    }    
    public void agregar_medio(int data, int posicion) {
        if (posicion < 0) {
            System.out.println("Posición no válida.");
            return;
        }        
        //Si la posición es 0, es equivalente a agregar_primero
        if (posicion == 0) {
            agregar_primero(data);
            return;
        }        
        Node nuevoNodo = new Node(data);
        Node actual = head;
        int posicion_actual = 0;
        
        //Avanzamos hasta la posición anterior a donde queremos insertar
        while (actual != null && posicion_actual < posicion - 1) {
            actual = actual.siguiente;
            posicion_actual++;
        }        
        //Verificamos si llegamos al final antes de la posición deseada
        if (actual == null) {
            System.out.println("Posición fuera de rango. Se agregó al final.");
            add(data);//Agregamos al final si la posición es mayor que el tamaño
        } else {
            //Insertamos el nuevo nodo
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
        }
    }    

    public void remove(int data) {
        //Si la lista está vacía, no hay nada que hacer
        if (head == null) {
            return;
        }
        
        //Si el valor está en la cabeza, la actualizamos
        if (head.data == data) {
            head = head.siguiente;
            return;
        }

        //Buscamos el nodo anterior al que contiene el valor
        Node actual = head;
        Node toDelete = null;   
        
        //Buscar el último nodo con el dato
        while (actual != null) {
            if (actual.data == data) {
                toDelete = actual;
            }
            actual = actual.siguiente;
        }
        
        // Si no se encontró el dato
        if (toDelete == null) return;
        
        // Caso especial: el nodo a eliminar es el head
        if (toDelete == head) {
            head = head.siguiente;
            return;
        }        
        // Buscar el nodo anterior al que queremos eliminar
        actual = head;
        while (actual.siguiente != toDelete) {
            actual = actual.siguiente;
        }        
        // Eliminar el nodo
        actual.siguiente = toDelete.siguiente;
    }    
    //Método para mostrar todos los valores de la lista
    public void mostar_lista() {
        Node actual = head;
        System.out.print("Lista: ");
        while (actual != null) {
            System.out.print(actual.data + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }    
    //Método para revertir el orden de la lista enlazada.    
    public void reverse() {
        Node anterior = null;
        Node actual = head;
        Node siguiente = null;
        
        while (actual != null) {
            siguiente = actual.siguiente;//Guardamos la referencia al siguiente nodo
            actual.siguiente = anterior;//Cambiamos el puntero al nodo anterior
            anterior = actual;//Movemos el anterior al nodo actual
            actual = siguiente;//Movemos dato al siguiente nodo
        }        
        head = anterior; 
    }
    public boolean contains(int value) {
        Node actual = head;
        while (actual != null) {
            if (actual.data == value) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }
}