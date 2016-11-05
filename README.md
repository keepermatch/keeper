App name: Keeper

Description: Keeper is an app where friends play matchmaker. Unlike dating apps, profiles on Keeper are not self-generated, they are formed by getting one's friends to write a 140 character 'vouch' for them. Additionally, on Keeper, you can't swipe for your friends - you rely on your matchmakers (your friends/family) to curate your matches. You can be a matchmaker too on Keeper - and if you see someone you'd rather date yourself, you can 'Keep' that person.

Wireframes:
  See https://invis.io/S5981FZGM - password is 'codepath'

Core User Stories:
1. User Creation
  The user logs in using FB OAuth Login, then we collect some basic details

  We request the following FB permissions: 
    birthday (for age)
    gender
    location
    email
    profile photos
    education
  User must manually enter the following:
    Single / Not-single
    Interested in men/women/both
    Location if not provided by FB or not in area
    Height
    Job
2. Select a friend to swipe for or vouch for
  A user can select a friend to vouch or swipe for from one of the following sources:
    Contacts
    FB friends using Keeper
3. Compose Vouch
  A vouch is a 140 character description of why your friend is a keeper (why they would be a great long-term relationship partner)
4. Accept/Reject Vouch
  When someone writes a vouch for you you can accept or reject it
5. Swipe
  Swipe left or right on a profile (heart or X) to suggest or reject for your friend, or keep for yourself
6. Edit Profile
  change photos, update basic stats
7. Chat
  using layer SDK

Optional stories:
1. waitlist for new users
2. app introduction set of screens
3. settings
  user can delete account, change status from single to not-single
4. push notifications
