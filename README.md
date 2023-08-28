# Scape: TTD

## Purpose

This system's purpose is to allow users to register life small and large trophies (Accolades) in their respective
communities while centralizing their individual story progress. The system will handle user registration, community
enrollment, and accolade progress tracking.


## Workflow

The system workflow can be summarized as follows:

1. **User Registration**:
    - The user accesses the registration page through the user interface.
    - The user provides their details, such as name, email, and password.
    - The registration module validates the information and stores it in the database.
    - Upon successful registration, the user is redirected to the community selection page.

2. **Community Enrollment**:
    - The user selects a community from the available options.
    - The community management module checks the user's eligibility for the community.
    - If eligible, the user is enrolled in the community, and the accolade progress tracking starts.
    - The community enrollment and accolade progress are stored in the database.

3. **Accolade Tracking**:
    - The user can register and update their accolades through the user interface.
    - The accolade tracking module validates and stores the accolade information in the database.
    - The user interface displays the accolade progress to the user.

## Data Storage

The system will utilize PostgreSQL to (a relational database) to store user information, community details, accolade
progress, and other relevant data. The database will have tables for users, communities, accolades, and progress
tracking.

