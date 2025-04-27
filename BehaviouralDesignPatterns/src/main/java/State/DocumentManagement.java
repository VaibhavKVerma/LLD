package State;

public class DocumentManagement {

    interface DocumentState {
        void approve(DocumentContext documentContext);
        void publish(DocumentContext documentContext);
        String getState();
    }

    static class Draft implements DocumentState {
        @Override
        public void approve(DocumentContext documentContext) {
            System.out.println("Moving from Draft to Review");
            documentContext.setState(new Review());
        }

        @Override
        public void publish(DocumentContext documentContext) {
            System.out.println("Cannot publish directly from Draft");
        }

        @Override
        public String getState() {
            return "DRAFT";
        }
    }

    static class Review implements DocumentState {
        @Override
        public void approve(DocumentContext documentContext) {
            System.out.println("Already approved");
        }

        @Override
        public void publish(DocumentContext documentContext) {
            System.out.println("Moving from Review to Published");
            documentContext.setState(new Published());
        }

        @Override
        public String getState() {
            return "REVIEW";
        }
    }

    static class Published implements DocumentState {
        @Override
        public void approve(DocumentContext documentContext) {
            System.out.println("Cannot approve a Published document");
        }

        @Override
        public void publish(DocumentContext documentContext) {
            System.out.println("Already published");
        }

        @Override
        public String getState() {
            return "PUBLISHED";
        }
    }

    static class DocumentContext {
        private DocumentState documentState;

        DocumentContext() {
            this.documentState = new Draft();
        }

        public void setState(DocumentState documentState) {
            this.documentState = documentState;
        }

        public String getCurrentState() {
            return documentState.getState();
        }

        public void approve() {
            this.documentState.approve(this);
        }

        public void publish() {
            this.documentState.publish(this);
        }
    }

    public static void main(String [] args){
        DocumentContext doc = new DocumentContext();
        doc.approve();  // Moving from Draft to Review
        doc.publish();  // Moving from Review to Published
        doc.approve();  // Should print: Cannot approve a Published document
        doc.publish();  // Should print: Already published
    }
}
