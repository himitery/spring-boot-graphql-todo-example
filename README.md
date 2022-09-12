# spring boot graphql todo example

```
spring-boot-starter-graphql를 사용하여 제작한 간단한 Todo CRUD
```

## GraphQL Schema

```graphql
### Type ###
type Todo {
    id: String!,
    title: String!,
    content: String,
    status: Boolean!,
    createdAt: String!,
    updatedAt: String!
}

input CreateTodoProps {
    title: String!,
    content: String
}

input UpdateTodoProps {
    id: String!,
    title: String,
    content: String,
}

### Query ###
type Query {
    todo(todoId: String!): Todo!,
    todos: [Todo!]!
}

### Mutation ###
type Mutation {
    createTodo(props: CreateTodoProps): Todo!,
    updateTodo(props: UpdateTodoProps): Todo!,
    updateTodoStatus(todoId: String!): Todo!
    deleteTodo(todoId: String!): Boolean!,
}
```
