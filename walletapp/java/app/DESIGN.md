# Wallet Application Architecture

This document describes the architecture of the Wallet application, which follows the Hexagonal Architecture (Ports and Adapters) pattern.

## Architecture Overview

The application is structured into the following layers:

```
src/main/java/com/technogise/foundation/
├── cli/                  # Input Adapters (Primary/Driving)
│   └── command/         # CLI Commands
├── service/             # Application Core
│   └── interfaces/      # Ports
├── repository/          # Output Adapters (Secondary/Driven)
│   └── inmemory/       # In-memory implementations
├── model/              # Domain Models
└── config/             # Dependency Injection
```

### Layers

1. **Domain Layer** (`model/`)
   - Contains the core business entities: `User`, `Account`, `Transaction`
   - Models are immutable and encapsulate business rules
   - No dependencies on other layers

2. **Application Core** (`service/`)
   - Contains business logic and use cases
   - Defines ports (interfaces) for external dependencies
   - No dependencies on infrastructure or frameworks

3. **Input Adapters** (`cli/`)
   - Handles user input through CLI
   - Implements command pattern for different operations
   - Depends on application core through ports

4. **Output Adapters** (`repository/`)
   - Implements persistence and external services
   - Provides in-memory implementations for testing
   - Implements ports defined by application core

5. **Configuration** (`config/`)
   - Composes the application components
   - Provides dependency injection
   - Single composition root

## Key Design Decisions

1. **Immutability**
   - Domain models are immutable
   - State changes create new instances
   - Thread-safe by design

2. **Interface Segregation**
   - Core interfaces split into focused roles:
     - `UserRepository`: User persistence
     - `TransactionStore`: Transaction history
     - `MoneyOps`: Money operations
     - `BalanceEnquiry`: Balance queries

3. **Dependency Inversion**
   - Core depends on abstractions
   - Implementations depend on interfaces
   - Easy to swap implementations

4. **Command Pattern**
   - Each CLI operation is a command
   - Commands encapsulate operation logic
   - Easy to add new operations

## Testing Strategy

1. **Unit Tests**
   - Test domain models in isolation
   - Test use cases with mock repositories
   - Test commands with mock services

2. **Integration Tests**
   - Test repository implementations
   - Test service layer with real repositories
   - Test CLI with mock input/output

3. **End-to-End Tests**
   - Test complete workflows
   - Use in-memory implementations
   - Verify system behavior

## Future Improvements

1. **Persistence**
   - Add database implementations
   - Implement transaction boundaries
   - Add data migration support

2. **API Layer**
   - Add REST API adapter
   - Implement API versioning
   - Add API documentation

3. **Security**
   - Add authentication
   - Implement authorization
   - Add audit logging

4. **Monitoring**
   - Add metrics collection
   - Implement health checks
   - Add performance monitoring 