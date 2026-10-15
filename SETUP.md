# Apex Electric Cycles

Static website. No dependency install or build step required.

Upload the entire public folder to the repository root, preserving public/index.html. Do not upload the ZIP itself.

Cloudflare Pages settings:
- Production branch: main
- Framework preset: None
- Build command: leave blank
- Build output directory: public

The HTML currently includes noindex,nofollow for review. This discourages indexing but is NOT access control. Set up Cloudflare Access before deployment if private review is required. Remove the robots meta tag when approved for public launch.

Service chooser prepares an email in the visitor's mail app. It does not submit a form, store personal information, or confirm bookings. No analytics or cookies are configured.

Brand mark is a text treatment and bicycle is an original SVG illustration; replace with approved business logo and photos when supplied. No phone, street address, hours, prices, or accreditation claims have been invented.

Before launch: review copy, confirm contact details, configure domain and access, test on phone/desktop, and preserve Google Workspace DNS records when changing nameservers.
