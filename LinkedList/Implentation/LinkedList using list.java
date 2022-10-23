class MyLinkedList {
        List<Integer> values;

        public MyLinkedList() {
            values = new ArrayList<>();
        }

        public int get(int index) {
            if (index < values.size()) {
                return values.get(index);
            }
            return -1;
        }

        public void addAtHead(int val) {
            values.add(0, val);
        }

        public void addAtTail(int val) {
            values.add(val);
        }

        public void addAtIndex(int index, int val) {
            if (index == values.size()) {
                values.add(val);
            } else if (index < values.size()) {
                values.add(index, val);
            }
        }

        public void deleteAtIndex(int index) {
            if (index < values.size()) {
                values.remove(index);
            }
        }
    }
