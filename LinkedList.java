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
    public void agregar_medio(int data, int position) {
        if (position < 0) {
            System.out.println("Posición no válida.");
            return;
        }        
        //Si la posición es 0, es equivalente a agregar_primero
        if (position == 0) {
            agregar_primero(data);
            return;
        }        
        Node nuevoNodo = new Node(data);
        Node actual = head;
        int posicion_actual = 0;
        
        //Avanzamos hasta la posición anterior a donde queremos insertar
        while (actual != null && posicion_actual < position - 1) {
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
        
        Node actual = head;
        //Buscamos el nodo anterior al que contiene el valor
        while (actual.siguiente != null && actual.siguiente.data != data) {
            actual = actual.siguiente;
        }
        
        //Si el nodo es encontrado se elimina
        if (actual.siguiente != null && actual.siguiente.data == data) {
            actual.siguiente = actual.siguiente.siguiente;
        }
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
            anterior = actual;//Movemos prev al nodo actual
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