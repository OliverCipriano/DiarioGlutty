package com.ejemplo.diarioglutty.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/ejemplo/diarioglutty/viewmodel/NotasViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "notas", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/ejemplo/diarioglutty/viewmodel/Nota;", "getNotas", "()Lkotlinx/coroutines/flow/StateFlow;", "repo", "Lcom/ejemplo/diarioglutty/repository/NoteRepository;", "agregar", "Lkotlinx/coroutines/Job;", "texto", "", "categoria", "foto", "Landroid/net/Uri;", "eliminar", "id", "", "Companion", "app_debug"})
public final class NotasViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.ejemplo.diarioglutty.repository.NoteRepository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.ejemplo.diarioglutty.viewmodel.Nota>> notas = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ejemplo.diarioglutty.viewmodel.NotasViewModel.Companion Companion = null;
    
    public NotasViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.ejemplo.diarioglutty.viewmodel.Nota>> getNotas() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job agregar(@org.jetbrains.annotations.NotNull()
    java.lang.String texto, @org.jetbrains.annotations.NotNull()
    java.lang.String categoria, @org.jetbrains.annotations.Nullable()
    android.net.Uri foto) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job eliminar(long id) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/ejemplo/diarioglutty/viewmodel/NotasViewModel$Companion;", "", "()V", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "app", "Landroid/app/Application;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.lifecycle.ViewModelProvider.Factory factory(@org.jetbrains.annotations.NotNull()
        android.app.Application app) {
            return null;
        }
    }
}