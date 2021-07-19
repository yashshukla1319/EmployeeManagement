# EmployeeManagement

# **Iteration 1**

## *APIs*
#### CRUD for employee REST API
- CRUD for a single employee `done`
- Get employees by list of IDs`done`
- Employee search by criteria ( name, department )`done`
- Paginated employee search`done`

#### CRUD for department REST API
- CRUD for single department
- API to add and remove employees in a department
  - Check if the employee exists in any other department or not

#### Payroll REST API
- For counting salary based on number of unpaid leaves

#### Analytics REST API
- Total salary payout by department
- Average paid and unpaid leaves by department


## *Tech stack and tools*
- Spring boot
- Oracle
- JDBC (no hibernate or spring data JPA for now. We will use that in next iteration)
- Java 11
- IntelliJ Idea
- Github
- JUnit
- Maven
- cUrl / Postman

## *Recommendations*
- Use streams and lambdas for all collection operations
- Use SOLID principles of object oriented programming
- Write tests first and then write actual code
- Do development on local->commit->push to your fork->open PR for employee management repo

# **Iteration 2**

- CRUD for leaves and approval
- HR department data to manage leaves
- spring data JPA integration
- swagger integration
- Containerization with Docker
- Github pages integration
- Integration with Jenkins
- Integration with static code analysis
