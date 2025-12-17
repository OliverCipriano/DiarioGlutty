package com.ejemplo.diarioglutty.auth;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/ejemplo/diarioglutty/auth/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "repo", "Lcom/ejemplo/diarioglutty/auth/AuthRepository;", "(Lcom/ejemplo/diarioglutty/auth/AuthRepository;)V", "_ui", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ejemplo/diarioglutty/auth/LoginUiState;", "ui", "Lkotlinx/coroutines/flow/StateFlow;", "getUi", "()Lkotlinx/coroutines/flow/StateFlow;", "login", "", "onSuccess", "Lkotlin/Function0;", "onEmailChange", "v", "", "onPasswordChange", "Companion", "app_debug"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.ejemplo.diarioglutty.auth.AuthRepository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ejemplo.diarioglutty.auth.LoginUiState> _ui = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.ejemplo.diarioglutty.auth.LoginUiState> ui = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ejemplo.diarioglutty.auth.LoginViewModel.Companion Companion = null;
    
    public LoginViewModel(@org.jetbrains.annotations.NotNull()
    com.ejemplo.diarioglutty.auth.AuthRepository repo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.ejemplo.diarioglutty.auth.LoginUiState> getUi() {
        return null;
    }
    
    public final void onEmailChange(@org.jetbrains.annotations.NotNull()
    java.lang.String v) {
    }
    
    public final void onPasswordChange(@org.jetbrains.annotations.NotNull()
    java.lang.String v) {
    }
    
    public final void login(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/ejemplo/diarioglutty/auth/LoginViewModel$Companion;", "", "()V", "provideFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "repo", "Lcom/ejemplo/diarioglutty/auth/AuthRepository;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.lifecycle.ViewModelProvider.Factory provideFactory(@org.jetbrains.annotations.NotNull()
        com.ejemplo.diarioglutty.auth.AuthRepository repo) {
            return null;
        }
    }
}