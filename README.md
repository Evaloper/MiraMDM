# MiraMDM

# Overview

This is a Mobile Device Management (MDM) system with the objective of providing
a software solution that allows organizations to manage, secure, and monitor mobile 
devices within their network. It enables IT administrators to enforce security policies, 
deploy applications, and ensure compliance across various devices

## Setup on you local

- Fork the repository
- Clone the forked repository
- Edit postgres credential in application.prop file to your local credential
- Run application

## Structure

Project Structure

| Directory                                  | Description |
|:-------------------------------------------| :--- |
| `src/main/frontend/`                       | Client-side source directory |
| &nbsp;&nbsp;&nbsp;&nbsp;`index.html`       | HTML template |
| &nbsp;&nbsp;&nbsp;&nbsp;`index.ts`         | Frontend entrypoint |
| &nbsp;&nbsp;&nbsp;&nbsp;`main-layout.ts`   | Main layout Web Component (optional) |
| &nbsp;&nbsp;&nbsp;&nbsp;`views/`           | UI views Web Components (TypeScript / HTML) |
| &nbsp;&nbsp;&nbsp;&nbsp;`styles/`          | Styles directory (CSS) |
| `src/main/java/<groupId>/`                 | Server-side source directory |
| &nbsp;&nbsp;&nbsp;&nbsp;`Application.java` | Server entrypoint |
| &nbsp;&nbsp;&nbsp;&nbsp;`AppShell.java`    | application-shell configuration |

