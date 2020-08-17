//Coded EXCLUSIVELY by Adithya Swaminathan
public class DoublyLinkedList<E>
{
    private ListNode root;
    private ListNode end;
    public DoublyLinkedList()
    {
        root = null;
        end= null;
    }
    public DoublyLinkedList(E i)
    {
        root = new ListNode(i);
        end = null;
    }
    public ListNode getRoot()
    {
        if(root == null)
            throw new NullPointerException();
        return root;
    }
    public void set(int index, E value)
    {
        int iterator = 0;
        for(ListNode listNode=root; listNode!=null;listNode=listNode.getNext())
        {
            if(iterator == index)
                listNode.setValue(value);
            iterator++;
        }
    }
    public E get(int index)
    {
        int iterator = 0;
        for(ListNode listNode=root; listNode!=null;listNode=listNode.getNext())
        {
            if(iterator == index)
                return (E)listNode.getValue();
            iterator++;
        }
        return null;
    }
    public ListNode getEnd()
    {
        if(end == null)
            throw new NullPointerException();
        return end;
    }
    public int size()
    {
        int c =0;
        ListNode rot = root;
        for(ListNode x = rot; x!=null; x=x.getNext())
            c++;
        return c;
    }
    public void remove(int index)
    {
        if(index<0 || index>=size() || (size() == 0))
            throw new NullPointerException();
        else if(index == 0)
        {
            root.getNext().setPrevious(null);
            root = root.getNext();
        }
        else if (index == size()-1)
        {
            end.getPrevious().setNext(null);
            end=end.getPrevious();
        }
        else {
            int iterator =0;
            for(ListNode x = root; x!=null;x=x.getNext())
            {
                if(iterator == index)
                {
                    x.getPrevious().setNext(x.getNext());
                    x.getNext().setPrevious(x.getPrevious());
                }
                iterator++;
            }
        }
        
    }
    public void add(E i)
    {
        if(root == null)
        {
            root = new ListNode(i);
            end = root;
        }
        else{
            ListNode newEnd = new ListNode(i);
            end.setNext(newEnd);
            newEnd.setPrevious(end);
            end = newEnd;
        }
    }
    public void add(int index, E i)
    {
        ListNode listNode = new ListNode(i);
        if(index<0 || index>size() || (size() == 0))
            throw new NullPointerException();
        else if(index ==0)
        {
            if(root==null)
                add(i);
            else{
                listNode.setNext(root);
                root.setPrevious(listNode);
                root = listNode;
            }
        }
        else if(index==size())
        {
            add(i);
        }
        else if(index == size()-1)
        {
            if(end.hasPrevious())
            {
                listNode.setPrevious(end.getPrevious());
                end.getPrevious().setNext(listNode);
            }
            listNode.setNext(end);
            end.setPrevious(listNode);
            end = listNode.getNext();
        }
        else
        {
            int iterator =0;
            for(ListNode x = root; x!=null;x=x.getNext())
            {
                if(iterator == index)
                {
                    if(x.hasPrevious())
                    {
                        listNode.setPrevious(x.getPrevious());
                        x.getPrevious().setNext(listNode);
                    }
                    listNode.setNext(x);
                    x.setPrevious(listNode);
                    x = listNode.getNext();
                }
                iterator++;
            }
        }
    }
    public boolean contains(E i)
    {
        boolean cont=false;
        for(ListNode x = root;x!=null;x=x.getNext())
        {
            if(x.getValue().equals((Object)i))
                cont = true;
        }
        return cont;
    }
    public void clear()
    {
        root=null;
        end = null;
    }
    public String toString()
    {
        String s = "[";
        for(ListNode x = root; x!=null;x=x.getNext())
        {
            s+=x.getValue();
            if(x.hasNext())
                s+=", ";
        }
        s+="]";
        return s;
    }
    public String toReversedString()
    {
        String s = "[";
        for(ListNode x = end; x!=null;x=x.getPrevious())
        {
            s+=x.getValue();
            if(x.hasPrevious())
                s+=", ";
        }
        s+="]";
        return s;
    }
    //ListNode inner class
    public class ListNode
    {
        private Object value;
        private ListNode next;
        private ListNode previous;
        public ListNode(Object initValue)
        {
            value=initValue;
            next=null;
            previous = null;
        }
        public Object getValue()
        {
            return value;
        }
        public ListNode getNext()
        {
            return next;
        }
        public ListNode getPrevious()
        {
            return previous;
        }
        public void setValue(Object theNewValue)
        {
            value=theNewValue;
        }
        public void setNext(ListNode theNewNext)
        {
            next=theNewNext;
        }
        public void setPrevious(ListNode theNewPrevious)
        {
            previous = theNewPrevious;
        }
        public boolean hasNext()
        {
            return (next!=null);
        }
        public boolean hasPrevious()
        {
            return (previous!=null);
        }
    }

}