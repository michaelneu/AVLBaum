public class JSON {
    public static String Encode(Object[] avl) {
        String encoded = Encode(avl, 1);
        
        encoded = "{\n" + encoded + "\n}";
        
        return encoded;
    }
    
    private static String Encode(Object[] avl, int depth) {
        String spaces = GetSpaces(depth),
            text = "",
            comma = "\n";
        if (avl == null || avl[0] == null)
            return "";
        
        text += spaces + "\"" + avl[0].toString() + "\": {\n";
            
        if (avl[1] != null && avl[2] != null) {
            comma = ",\n";
        }
        
        if (avl[1] != null) {
            text += Encode((Object[])avl[1], depth + 1);
        }
        
        text += comma;
        
        if (avl[2] != null) {
            text += Encode((Object[])avl[2], depth + 1) + "\n";
        }
        
        text += spaces + "}";
        
        return text;
    }
    
    private static String GetSpaces(int count) {
        String text = "";
        
        for (int i = 0; i < count; i++) {
            text += "    ";
        }
        
        return text;
    }
}