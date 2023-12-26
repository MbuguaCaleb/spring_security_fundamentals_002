**Custom UserDetailsService**

```agsl

//Decorator Pattern of mapping our Custom User to the UserDetails spring security class.
//Decorator pattern is one of the ways that one class can be mapped into another
//We must map our custom user class into a class that spring can understand.

There three ways that our custom user can be mapped into UserDetails from spring
security,

1.User implements userDetails-->Not recommended, makes our code dirty because our class
is handling too many things.

2.We can use an Object Mapper.From User to UserDetails.

3.We can use the decorator pattern, this is a pattern in spring that
is used in mapping one class to the other. recommeded approach.

```

**How do i use custom user details??**

```agsl
1.I implement an instance of the UserDetailsService and put it in the spring context.

(Complex DB implementation)

2.I can also override my bean and add the user in memory,and also provide my user in userDetails.

```